package net.deechael.randomstuff;

import net.deechael.randomstuff.registry.BlockRegistry;
import net.deechael.randomstuff.registry.CreativeModeTabRegistry;
import net.deechael.randomstuff.registry.ItemRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class DsRandomStuff {

    public DsRandomStuff(IEventBus modEventBus, ModContainer modContainer) {
        BlockRegistry.init(modEventBus);
        ItemRegistry.init(modEventBus);
        CreativeModeTabRegistry.init(modEventBus);
    }

}
