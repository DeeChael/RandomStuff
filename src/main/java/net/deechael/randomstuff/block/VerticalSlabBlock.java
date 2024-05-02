package net.deechael.randomstuff.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Arrays;

public class VerticalSlabBlock extends Block implements SimpleWaterloggedBlock {

    public static final MapCodec<VerticalSlabBlock> CODEC = simpleCodec(VerticalSlabBlock::new);
    public static final EnumProperty<VerticalSlabType> TYPE = EnumProperty.create("type", VerticalSlabType.class);
    protected static final VoxelShape EAST_AABB = Block.box(8.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape WEST_AABB = Block.box(0.0, 0.0, 0.0, 8.0, 16.0, 16.0);
    protected static final VoxelShape NORTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 8.0);
    protected static final VoxelShape SOUTH_AABB = Block.box(0.0, 0.0, 8.0, 16.0, 16.0, 16.0);

    @Override
    public @NotNull MapCodec<? extends VerticalSlabBlock> codec() {
        return CODEC;
    }

    public VerticalSlabBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(TYPE, VerticalSlabType.EAST).setValue(BlockStateProperties.WATERLOGGED, false));
    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, BlockStateProperties.WATERLOGGED);
    }

    @Override
    protected @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos blockPos, @NotNull CollisionContext context) {
        VerticalSlabType slabType = state.getValue(TYPE);
        return switch (slabType) {
            case DOUBLE -> Shapes.block();
            case WEST -> WEST_AABB;
            case NORTH -> NORTH_AABB;
            case SOUTH -> SOUTH_AABB;
            default -> EAST_AABB;
        };
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        BlockState blockstate = context.getLevel().getBlockState(blockPos);
        if (blockstate.is(this)) {
            return blockstate.setValue(TYPE, VerticalSlabType.DOUBLE).setValue(BlockStateProperties.WATERLOGGED, false);
        } else {
            FluidState fluidstate = context.getLevel().getFluidState(blockPos);
            BlockState defaultState = this.defaultBlockState()
                    .setValue(TYPE, VerticalSlabType.EAST)
                    .setValue(BlockStateProperties.WATERLOGGED, fluidstate.getType() == Fluids.WATER);
            return defaultState.setValue(TYPE, VerticalSlabType.fromDirection(getPlacing(context)));
        }
    }

    @Override
    protected boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        ItemStack itemstack = context.getItemInHand();
        VerticalSlabType slabType = state.getValue(TYPE);
        if (slabType == VerticalSlabType.DOUBLE || !itemstack.is(this.asItem())) {
            return false;
        } else if (context.replacingClickedOnBlock()) {
            if (context.getClickedFace() == Direction.UP || context.getClickedFace() == Direction.DOWN) {
                return false;
            } else {
                return context.getClickedFace() == slabType.getDirection().getOpposite();
            }
        } else {
            return true;
        }
    }

    private Direction getNearestLooking(BlockPlaceContext context) {
        for (Direction direction : context.getNearestLookingDirections()) {
            if (direction == Direction.UP || direction == Direction.DOWN)
                continue;
            return direction;
        }
        throw new RuntimeException("HOW!");
    }

    private Direction getPlacing(BlockPlaceContext context) {
        Player player = context.getPlayer();
        Direction direction = player != null ? player.getDirection() : getNearestLooking(context); // If player is null, the direction could be an inaccurate value; HOWEVER I cant replace this null check because if removed it the game may crash, Crashing will make player very uncomfortable.
        if (context.getClickedFace() == direction.getOpposite()) {
            return direction;
        } else {
            if (direction == Direction.WEST || direction == Direction.EAST) {
                return context.getClickLocation().x - context.getClickedPos().getX() > 0.5 ? Direction.EAST : Direction.WEST;
            } else {
                return context.getClickLocation().z - context.getClickedPos().getZ() > 0.5 ? Direction.SOUTH : Direction.NORTH;
            }
        }
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState pState) {
        return pState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public boolean placeLiquid(@NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, BlockState state, @NotNull FluidState fluidState) {
        return state.getValue(TYPE) != VerticalSlabType.DOUBLE && SimpleWaterloggedBlock.super.placeLiquid(levelAccessor, blockPos, state, fluidState);
    }

    @Override
    public boolean canPlaceLiquid(@Nullable Player player, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, BlockState blockState, @NotNull Fluid fluid) {
        return blockState.getValue(TYPE) != VerticalSlabType.DOUBLE && SimpleWaterloggedBlock.super.canPlaceLiquid(player, blockGetter, blockPos, blockState, fluid);
    }

    @Override
    protected @NotNull BlockState updateShape(BlockState blockState, @NotNull Direction direction, @NotNull BlockState facingState, @NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockPos facingPos) {
        if (blockState.getValue(BlockStateProperties.WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return super.updateShape(blockState, direction, facingState, levelAccessor, blockPos, facingPos);
    }

    @Override
    protected boolean isPathfindable(@NotNull BlockState state, @NotNull PathComputationType pathComputationType) {
        return pathComputationType == PathComputationType.WATER && state.getFluidState().is(FluidTags.WATER);
    }

}
