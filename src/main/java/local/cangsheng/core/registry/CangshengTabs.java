package local.cangsheng.core.registry;

import local.cangsheng.Cangsheng;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/** Creates the mod's creative tab with all M0 item and block placeholders. */
public final class CangshengTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Cangsheng.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CANGSHENG = TABS.register(
            "cangsheng", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.cangsheng"))
                    .icon(() -> new ItemStack(CangshengItems.DEBUG_WAND.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(CangshengItems.HUANSHANG_TOKEN.get());
                        output.accept(CangshengItems.CHAOSONG_TOKEN.get());
                        output.accept(CangshengItems.QINGMO_TOKEN.get());
                        output.accept(CangshengItems.CANGQIONG_TOKEN.get());
                        output.accept(CangshengItems.QINGLUAN_TOKEN.get());
                        output.accept(CangshengItems.FOSI_TOKEN.get());
                        output.accept(CangshengItems.DEBUG_WAND.get());
                        output.accept(CangshengBlocks.SECT_ALTAR.get());
                    }).build());

    private CangshengTabs() {}

    public static void register(IEventBus modEventBus) {
        TABS.register(modEventBus);
    }
}
