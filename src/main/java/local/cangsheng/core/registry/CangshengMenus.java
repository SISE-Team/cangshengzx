package local.cangsheng.core.registry;

import local.cangsheng.Cangsheng;
import local.cangsheng.menu.CangshengMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/** Registers the empty skill-loadout menu type. */
public final class CangshengMenus {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, Cangsheng.MOD_ID);
    public static final DeferredHolder<MenuType<?>, MenuType<CangshengMenu>> SKILL_CONFIG = MENUS.register(
            "skill_config", () -> new MenuType<>(CangshengMenu::new, net.minecraft.world.flag.FeatureFlags.DEFAULT_FLAGS));

    private CangshengMenus() {}

    public static void register(IEventBus modEventBus) {
        MENUS.register(modEventBus);
    }
}
