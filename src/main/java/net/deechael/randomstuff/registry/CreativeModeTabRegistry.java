package net.deechael.randomstuff.registry;

import net.deechael.randomstuff.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class CreativeModeTabRegistry {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BLOCKS = CREATIVE_MODE_TABS.register("building_blocks", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".building_blocks"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ItemRegistry.OAK_VERTICAL_SLAB.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ItemRegistry.OAK_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.SPRUCE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.BIRCH_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.JUNGLE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.ACACIA_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.DARK_OAK_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.CRIMSON_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.WARPED_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.MANGROVE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.BAMBOO_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.CHERRY_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.BAMBOO_MOSAIC_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.STONE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.SMOOTH_STONE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.STONE_BRICK_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.SANDSTONE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.PURPUR_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.QUARTZ_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.RED_SANDSTONE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.BRICK_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.COBBLESTONE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.NETHER_BRICK_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.PETRIFIED_OAK_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.PRISMARINE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.PRISMARINE_BRICK_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.DARK_PRISMARINE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.POLISHED_GRANITE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.SMOOTH_RED_SANDSTONE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.MOSSY_STONE_BRICK_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.POLISHED_DIORITE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.MOSSY_COBBLESTONE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.END_STONE_BRICK_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.SMOOTH_SANDSTONE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.SMOOTH_QUARTZ_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.GRANITE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.ANDESITE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.RED_NETHER_BRICK_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.POLISHED_ANDESITE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.DIORITE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.CUT_SANDSTONE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.CUT_RED_SANDSTONE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.BLACKSTONE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.POLISHED_BLACKSTONE_BRICK_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.POLISHED_BLACKSTONE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.TUFF_BRICK_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.COBBLED_DEEPSLATE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.POLISHED_DEEPSLATE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.DEEPSLATE_TILE_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.DEEPSLATE_BRICK_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.WAXED_WEATHERED_CUT_COPPER_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.WAXED_EXPOSED_CUT_COPPER_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.WAXED_CUT_COPPER_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.OXIDIZED_CUT_COPPER_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.WEATHERED_CUT_COPPER_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.EXPOSED_CUT_COPPER_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.CUT_COPPER_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.WAXED_OXIDIZED_CUT_COPPER_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.MUD_BRICK_VERTICAL_SLAB.get());
                output.accept(ItemRegistry.OAK_CORNER.get());
                output.accept(ItemRegistry.OAK_PILLAR.get());
            }).build());

    public static void init(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    private CreativeModeTabRegistry() {
    }

}
