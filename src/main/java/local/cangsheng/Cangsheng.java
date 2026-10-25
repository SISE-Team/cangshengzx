package local.cangsheng;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;
import local.cangsheng.core.registry.CangshengItems;
import local.cangsheng.core.registry.CangshengBlocks;
import local.cangsheng.core.registry.CangshengEntities;
import local.cangsheng.core.registry.CangshengEffects;
import local.cangsheng.core.registry.CangshengAttributes;
import local.cangsheng.core.registry.CangshengDataComponents;
import local.cangsheng.core.registry.CangshengAttachments;
import local.cangsheng.core.registry.CangshengSounds;
import local.cangsheng.core.registry.CangshengParticles;
import local.cangsheng.core.registry.CangshengMenus;
import local.cangsheng.core.registry.CangshengTabs;
import local.cangsheng.core.registry.CangshengDataRegistries;
import local.cangsheng.core.event.CangshengGameTests;
import local.cangsheng.core.registry.CangshengCommands;
import local.cangsheng.core.registry.CangshengGameTestTypes;
import local.cangsheng.datagen.CangshengDataGen;

@Mod(Cangsheng.MOD_ID)
public final class Cangsheng {
    public static final String MOD_ID = "cangsheng";

    public Cangsheng(IEventBus modEventBus, ModContainer modContainer) {
        CangshengItems.register(modEventBus);
        CangshengBlocks.register(modEventBus);
        CangshengEntities.register(modEventBus);
        CangshengEffects.register(modEventBus);
        CangshengAttributes.register(modEventBus);
        CangshengDataComponents.register(modEventBus);
        CangshengAttachments.register(modEventBus);
        CangshengSounds.register(modEventBus);
        CangshengParticles.register(modEventBus);
        CangshengMenus.register(modEventBus);
        CangshengTabs.register(modEventBus);
        CangshengGameTestTypes.register(modEventBus);
        modEventBus.addListener(CangshengDataRegistries::register);
        modEventBus.addListener(CangshengGameTests::register);
        modEventBus.addListener(CangshengDataGen::register);
        NeoForge.EVENT_BUS.addListener(CangshengCommands::register);
    }
}
