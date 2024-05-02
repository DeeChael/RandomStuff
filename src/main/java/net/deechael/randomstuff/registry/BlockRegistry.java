package net.deechael.randomstuff.registry;

import net.deechael.randomstuff.Constants;
import net.deechael.randomstuff.block.CornerBlock;
import net.deechael.randomstuff.block.PillarBlock;
import net.deechael.randomstuff.block.VerticalSlabBlock;
import net.deechael.randomstuff.block.WeatheringCopperVerticalSlabBlock;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.reflect.Field;

public final class BlockRegistry {

    public static void main(String[] args) {
    }

    public final static DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Constants.MOD_ID);

    // Vertical Slabs
    public final static DeferredBlock<VerticalSlabBlock> PRISMARINE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "prismarine_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> PRISMARINE_BRICK_VERTICAL_SLAB = BLOCKS.registerBlock(
            "prismarine_brick_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIAMOND)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> DARK_PRISMARINE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "dark_prismarine_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIAMOND)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> OAK_VERTICAL_SLAB = BLOCKS.registerBlock(
            "oak_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava());
    public final static DeferredBlock<VerticalSlabBlock> SPRUCE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "spruce_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PODZOL)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
    );
    public final static DeferredBlock<VerticalSlabBlock> BIRCH_VERTICAL_SLAB = BLOCKS.registerBlock(
            "birch_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
    );
    public final static DeferredBlock<VerticalSlabBlock> JUNGLE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "jungle_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DIRT)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
    );
    public final static DeferredBlock<VerticalSlabBlock> ACACIA_VERTICAL_SLAB = BLOCKS.registerBlock(
            "acacia_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
    );
    public final static DeferredBlock<VerticalSlabBlock> CHERRY_VERTICAL_SLAB = BLOCKS.registerBlock(
            "cherry_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.CHERRY_WOOD)
                    .ignitedByLava()
    );
    public final static DeferredBlock<VerticalSlabBlock> DARK_OAK_VERTICAL_SLAB = BLOCKS.registerBlock(
            "dark_oak_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
    );
    public final static DeferredBlock<VerticalSlabBlock> MANGROVE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "mangrove_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava()
    );
    public final static DeferredBlock<VerticalSlabBlock> BAMBOO_VERTICAL_SLAB = BLOCKS.registerBlock(
            "bamboo_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.BAMBOO_WOOD)
                    .ignitedByLava()
    );
    public final static DeferredBlock<VerticalSlabBlock> BAMBOO_MOSAIC_VERTICAL_SLAB = BLOCKS.registerBlock(
            "bamboo_mosaic_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.BAMBOO_WOOD)
                    .ignitedByLava()
    );
    public final static DeferredBlock<VerticalSlabBlock> STONE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "stone_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> SMOOTH_STONE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "smooth_stone_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> SANDSTONE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "sandstone_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> CUT_SANDSTONE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "cut_sandstone_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.SAND)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> PETRIFIED_OAK_VERTICAL_SLAB = BLOCKS.registerBlock(
            "petrified_oak_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> COBBLESTONE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "cobblestone_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> BRICK_VERTICAL_SLAB = BLOCKS.registerBlock(
            "brick_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> STONE_BRICK_VERTICAL_SLAB = BLOCKS.registerBlock(
            "stone_brick_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> MUD_BRICK_VERTICAL_SLAB = BLOCKS.registerBlock(
            "mud_brick_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 3.0F)
                    .sound(SoundType.MUD_BRICKS)
    );
    public final static DeferredBlock<VerticalSlabBlock> NETHER_BRICK_VERTICAL_SLAB = BLOCKS.registerBlock(
            "nether_brick_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.NETHER)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)
                    .sound(SoundType.NETHER_BRICKS)
    );
    public final static DeferredBlock<VerticalSlabBlock> QUARTZ_VERTICAL_SLAB = BLOCKS.registerBlock(
            "quartz_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.QUARTZ)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> RED_SANDSTONE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "red_sandstone_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> CUT_RED_SANDSTONE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "cut_red_sandstone_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> PURPUR_VERTICAL_SLAB = BLOCKS.registerBlock(
            "purpur_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_MAGENTA)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> POLISHED_GRANITE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "polished_granite_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.POLISHED_GRANITE)
        );
    public final static DeferredBlock<VerticalSlabBlock> SMOOTH_RED_SANDSTONE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "smooth_red_sandstone_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.SMOOTH_RED_SANDSTONE)
    );
    public final static DeferredBlock<VerticalSlabBlock> MOSSY_STONE_BRICK_VERTICAL_SLAB = BLOCKS.registerBlock(
            "mossy_stone_brick_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.MOSSY_STONE_BRICKS)
    );
    public final static DeferredBlock<VerticalSlabBlock> POLISHED_DIORITE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "polished_diorite_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.POLISHED_DIORITE)
    );
    public final static DeferredBlock<VerticalSlabBlock> MOSSY_COBBLESTONE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "mossy_cobblestone_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.MOSSY_COBBLESTONE)
    );
    public final static DeferredBlock<VerticalSlabBlock> END_STONE_BRICK_VERTICAL_SLAB = BLOCKS.registerBlock(
            "end_stone_brick_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.END_STONE_BRICKS)
    );
    public final static DeferredBlock<VerticalSlabBlock> SMOOTH_SANDSTONE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "smooth_sandstone_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.SMOOTH_SANDSTONE)
    );
    public final static DeferredBlock<VerticalSlabBlock> SMOOTH_QUARTZ_VERTICAL_SLAB = BLOCKS.registerBlock(
            "smooth_quartz_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.SMOOTH_QUARTZ)
    );
    public final static DeferredBlock<VerticalSlabBlock> GRANITE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "granite_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.GRANITE)
    );
    public final static DeferredBlock<VerticalSlabBlock> ANDESITE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "andesite_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.ANDESITE)
    );
    public final static DeferredBlock<VerticalSlabBlock> RED_NETHER_BRICK_VERTICAL_SLAB = BLOCKS.registerBlock(
            "red_nether_brick_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.RED_NETHER_BRICKS)
    );
    public final static DeferredBlock<VerticalSlabBlock> POLISHED_ANDESITE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "polished_andesite_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.POLISHED_ANDESITE)
    );
    public final static DeferredBlock<VerticalSlabBlock> DIORITE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "diorite_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.DIORITE)
    );
    public final static DeferredBlock<VerticalSlabBlock> CRIMSON_VERTICAL_SLAB = BLOCKS.registerBlock(
            "crimson_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.CRIMSON_PLANKS.defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.NETHER_WOOD)
    );
    public final static DeferredBlock<VerticalSlabBlock> WARPED_VERTICAL_SLAB = BLOCKS.registerBlock(
            "warped_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(Blocks.WARPED_PLANKS.defaultMapColor())
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.NETHER_WOOD)
    );
    public final static DeferredBlock<VerticalSlabBlock> BLACKSTONE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "blackstone_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.BLACKSTONE).strength(2.0F, 6.0F)
    );
    public final static DeferredBlock<VerticalSlabBlock> POLISHED_BLACKSTONE_BRICK_VERTICAL_SLAB = BLOCKS.registerBlock(
            "polished_blackstone_brick_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.POLISHED_BLACKSTONE_BRICKS)
                    .strength(2.0F, 6.0F)
    );    
    public final static DeferredBlock<VerticalSlabBlock> POLISHED_BLACKSTONE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "polished_blackstone_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.POLISHED_BLACKSTONE)
    );
    public final static DeferredBlock<VerticalSlabBlock> TUFF_BRICK_VERTICAL_SLAB = BLOCKS.registerBlock(
            "tuff_brick_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.TUFF_BRICKS)
    );
    public final static DeferredBlock<WeatheringCopperVerticalSlabBlock> OXIDIZED_CUT_COPPER_VERTICAL_SLAB = BLOCKS.register(
            "oxidized_cut_copper_vertical_slab",
            () -> new WeatheringCopperVerticalSlabBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.ofFullCopy(Blocks.OXIDIZED_CUT_COPPER))
    );
    public final static DeferredBlock<WeatheringCopperVerticalSlabBlock> WEATHERED_CUT_COPPER_VERTICAL_SLAB = BLOCKS.register(
            "weathered_cut_copper_vertical_slab",
            () -> new WeatheringCopperVerticalSlabBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.ofFullCopy(Blocks.WEATHERED_CUT_COPPER))
    );
    public final static DeferredBlock<WeatheringCopperVerticalSlabBlock> EXPOSED_CUT_COPPER_VERTICAL_SLAB = BLOCKS.register(
            "exposed_cut_copper_vertical_slab",
            () -> new WeatheringCopperVerticalSlabBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.ofFullCopy(Blocks.EXPOSED_CUT_COPPER))
    );
    public final static DeferredBlock<WeatheringCopperVerticalSlabBlock> CUT_COPPER_VERTICAL_SLAB = BLOCKS.register(
            "cut_copper_vertical_slab",
            () -> new WeatheringCopperVerticalSlabBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.ofFullCopy(Blocks.CUT_COPPER))
    );
    public final static DeferredBlock<VerticalSlabBlock> WAXED_OXIDIZED_CUT_COPPER_VERTICAL_SLAB = BLOCKS.registerBlock(
            "waxed_oxidized_cut_copper_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WAXED_OXIDIZED_CUT_COPPER).requiresCorrectToolForDrops()
    );
    public final static DeferredBlock<VerticalSlabBlock> WAXED_WEATHERED_CUT_COPPER_VERTICAL_SLAB = BLOCKS.registerBlock(
            "waxed_weathered_cut_copper_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WAXED_WEATHERED_CUT_COPPER).requiresCorrectToolForDrops()
    );
    public final static DeferredBlock<VerticalSlabBlock> WAXED_EXPOSED_CUT_COPPER_VERTICAL_SLAB = BLOCKS.registerBlock(
            "waxed_exposed_cut_copper_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WAXED_EXPOSED_CUT_COPPER).requiresCorrectToolForDrops()
    );
    public final static DeferredBlock<VerticalSlabBlock> WAXED_CUT_COPPER_VERTICAL_SLAB = BLOCKS.registerBlock(
            "waxed_cut_copper_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.WAXED_CUT_COPPER).requiresCorrectToolForDrops()
    );
    public final static DeferredBlock<VerticalSlabBlock> COBBLED_DEEPSLATE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "cobbled_deepslate_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.COBBLED_DEEPSLATE)
    );
    public final static DeferredBlock<VerticalSlabBlock> POLISHED_DEEPSLATE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "polished_deepslate_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.POLISHED_DEEPSLATE)
    );
    public final static DeferredBlock<VerticalSlabBlock> DEEPSLATE_TILE_VERTICAL_SLAB = BLOCKS.registerBlock(
            "deepslate_tile_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.DEEPSLATE_TILES)
    );
    public final static DeferredBlock<VerticalSlabBlock> DEEPSLATE_BRICK_VERTICAL_SLAB = BLOCKS.registerBlock(
            "deepslate_brick_vertical_slab",
            VerticalSlabBlock::new,
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.DEEPSLATE_BRICKS)
    );
    
    
    // Corners
    public final static DeferredBlock<CornerBlock> OAK_CORNER = BLOCKS.registerBlock(
            "oak_corner",
            CornerBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava());

    // Pillars
    public final static DeferredBlock<PillarBlock> OAK_PILLAR = BLOCKS.registerBlock(
            "oak_pillar",
            PillarBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.WOOD)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)
                    .ignitedByLava());

    public static void init(IEventBus eventBus) {
        BLOCKS.register(eventBus);

    }

    private BlockRegistry() {}

}
