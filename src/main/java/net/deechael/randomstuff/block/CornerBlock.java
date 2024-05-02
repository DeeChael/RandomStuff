package net.deechael.randomstuff.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
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

public class CornerBlock extends Block implements SimpleWaterloggedBlock {

    public static final MapCodec<CornerBlock> CODEC = simpleCodec(CornerBlock::new);
    public static final EnumProperty<CornerType> TYPE = EnumProperty.create("type", CornerType.class);
    protected static final VoxelShape ES_AABB = Shapes.or(
            Block.box(8.0, 0.0, 0.0, 16.0, 16.0, 16.0),
            Block.box(0.0, 0.0, 8.0, 8.0, 16.0, 16.0)
    );
    protected static final VoxelShape EN_AABB = Shapes.or(
            Block.box(8.0, 0.0, 0.0, 16.0, 16.0, 16.0),
            Block.box(0.0, 0.0, 0.0, 8.0, 16.0, 8.0)
    );
    protected static final VoxelShape WS_AABB = Shapes.or(
            Block.box(0.0, 0.0, 0.0, 8.0, 16.0, 16.0),
            Block.box(8.0, 0.0, 8.0, 16.0, 16.0, 16.0)
    );
    protected static final VoxelShape WN_AABB = Shapes.or(
            Block.box(0.0, 0.0, 0.0, 8.0, 16.0, 16.0),
            Block.box(8.0, 0.0, 0.0, 16.0, 16.0, 8.0)
    );

    @Override
    public @NotNull MapCodec<? extends CornerBlock> codec() {
        return CODEC;
    }

    public CornerBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(TYPE, CornerType.ES).setValue(BlockStateProperties.WATERLOGGED, false));
    }

    @Override
    protected boolean useShapeForLightOcclusion(@NotNull BlockState state) {
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, BlockStateProperties.WATERLOGGED);
    }

    @Override
    protected @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos blockPos, @NotNull CollisionContext context) {
        CornerType cornerType = state.getValue(TYPE);
        return switch (cornerType) {
            case ES -> ES_AABB;
            case EN -> EN_AABB;
            case WS -> WS_AABB;
            default -> WN_AABB;
        };
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(blockPos);
        BlockState defaultState = this.defaultBlockState()
                .setValue(TYPE, CornerType.ES)
                .setValue(BlockStateProperties.WATERLOGGED, fluidstate.getType() == Fluids.WATER);
        return defaultState.setValue(TYPE, getPlacing(context));
    }

    private CornerType getPlacing(BlockPlaceContext context) {
        Direction ew = context.getClickLocation().x - context.getClickedPos().getX() > 0.5 ? Direction.EAST : Direction.WEST;
        Direction ns = context.getClickLocation().z - context.getClickedPos().getZ() > 0.5 ? Direction.SOUTH : Direction.NORTH;
        if (ew == Direction.EAST) {
            if (ns == Direction.SOUTH)
                return CornerType.ES;
            else
                return CornerType.EN;
        } else {
            if (ns == Direction.SOUTH)
                return CornerType.WS;
            else
                return CornerType.WN;
        }
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState pState) {
        return pState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    public boolean placeLiquid(@NotNull LevelAccessor levelAccessor, @NotNull BlockPos blockPos, @NotNull BlockState state, @NotNull FluidState fluidState) {
        return SimpleWaterloggedBlock.super.placeLiquid(levelAccessor, blockPos, state, fluidState);
    }

    @Override
    public boolean canPlaceLiquid(@Nullable Player player, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @NotNull Fluid fluid) {
        return SimpleWaterloggedBlock.super.canPlaceLiquid(player, blockGetter, blockPos, blockState, fluid);
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
