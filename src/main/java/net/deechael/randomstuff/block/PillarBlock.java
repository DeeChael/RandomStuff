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

public class PillarBlock extends Block implements SimpleWaterloggedBlock {

    public static final MapCodec<PillarBlock> CODEC = simpleCodec(PillarBlock::new);
    public static final EnumProperty<PillarType> TYPE = EnumProperty.create("type", PillarType.class);
    protected static final VoxelShape ES_AABB = Block.box(8.0, 0.0, 8.0, 16.0, 16.0, 16.0);
    protected static final VoxelShape EN_AABB = Block.box(8.0, 0.0, 0.0, 16.0, 16.0, 8.0);
    protected static final VoxelShape WS_AABB = Block.box(0.0, 0.0, 8.0, 8.0, 16.0, 16.0);
    protected static final VoxelShape WN_AABB = Block.box(0.0, 0.0, 0.0, 8.0, 16.0, 8.0);
    protected static final VoxelShape ES_EN_AABB = Shapes.or(
            ES_AABB,
            EN_AABB
    );
    protected static final VoxelShape ES_WS_AABB = Shapes.or(
            ES_AABB,
            WS_AABB
    );
    protected static final VoxelShape ES_WN_AABB = Shapes.or(
            ES_AABB,
            WN_AABB
    );
    protected static final VoxelShape EN_WS_AABB = Shapes.or(
            EN_AABB,
            WS_AABB
    );
    protected static final VoxelShape EN_WN_AABB = Shapes.or(
            EN_AABB,
            WN_AABB
    );
    protected static final VoxelShape WS_WN_AABB = Shapes.or(
            WS_AABB,
            WN_AABB
    );

    @Override
    public @NotNull MapCodec<? extends PillarBlock> codec() {
        return CODEC;
    }

    public PillarBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(TYPE, PillarType.ES).setValue(BlockStateProperties.WATERLOGGED, false));
    }

    @Override
    protected boolean useShapeForLightOcclusion(@NotNull BlockState state) {
        return state.getValue(TYPE) != PillarType.FULL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(TYPE, BlockStateProperties.WATERLOGGED);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        BlockState blockstate = context.getLevel().getBlockState(blockPos);
        if (blockstate.is(this)) {
            PillarType oldType = blockstate.getValue(TYPE);
            if (oldType.getSerializedName().length() == 8) {
                return blockstate.setValue(TYPE, PillarType.FULL).setValue(BlockStateProperties.WATERLOGGED, false);
            } else {
                return blockstate.setValue(TYPE, oldType.tryAdd(getPlacing(context)));
            }
        } else {
            FluidState fluidstate = context.getLevel().getFluidState(blockPos);
            BlockState defaultState = this.defaultBlockState()
                    .setValue(TYPE, PillarType.ES)
                    .setValue(BlockStateProperties.WATERLOGGED, fluidstate.getType() == Fluids.WATER);
            return defaultState.setValue(TYPE, getPlacing(context));
        }
    }

    @Override
    protected @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos blockPos, @NotNull CollisionContext context) {
        PillarType pillarType = state.getValue(TYPE);
        return switch (pillarType) {
            case ES -> ES_AABB;
            case EN -> EN_AABB;
            case WS -> WS_AABB;
            case WN -> WN_AABB;
            case ES_EN -> VerticalSlabBlock.EAST_AABB;
            case ES_WS -> VerticalSlabBlock.SOUTH_AABB;
            case ES_WN -> ES_WN_AABB;
            case EN_WS -> EN_WS_AABB;
            case EN_WN -> VerticalSlabBlock.NORTH_AABB;
            case WS_WN -> VerticalSlabBlock.WEST_AABB;
            case ES_EN_WS -> CornerBlock.ES_AABB;
            case ES_EN_WN -> CornerBlock.EN_AABB;
            case ES_WS_WN -> CornerBlock.WS_AABB;
            case EN_WS_WN -> CornerBlock.WN_AABB;
            default -> Shapes.block();
        };
    }

    @Override
    protected boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        ItemStack itemstack = context.getItemInHand();
        PillarType pillarType = state.getValue(TYPE);
        if (pillarType == PillarType.FULL || !itemstack.is(this.asItem())) {
            return false;
        } else if (context.replacingClickedOnBlock()) {
            Direction clicked = context.getClickedFace();
            if (clicked == Direction.UP || clicked == Direction.DOWN) {
                return false;
            } else {
                return !pillarType.getSerializedName().contains(getPlacing(context).getSerializedName());
            }
        } else {
            return true;
        }
    }

    private PillarType getPlacing(BlockPlaceContext context) {
        // FIXME: UNSAFE function, better solution in need
        Direction clicked = context.getClickedFace();
        double deltaX = context.getClickLocation().x - context.getClickedPos().getX();
        double deltaZ = context.getClickLocation().z - context.getClickedPos().getZ();
        Direction ew = deltaX == 0.5 ? clicked : (deltaX > 0.5 ? Direction.EAST : Direction.WEST);
        Direction ns = deltaZ == 0.5 ? clicked : (deltaZ > 0.5 ? Direction.SOUTH : Direction.NORTH);
        if (ew == Direction.EAST) {
            if (ns == Direction.SOUTH)
                return PillarType.ES;
            else
                return PillarType.EN;
        } else {
            if (ns == Direction.SOUTH)
                return PillarType.WS;
            else
                return PillarType.WN;
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
