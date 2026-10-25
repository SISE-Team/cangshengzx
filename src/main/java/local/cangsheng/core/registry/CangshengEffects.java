package local.cangsheng.core.registry;

import local.cangsheng.Cangsheng;
import local.cangsheng.core.compat.CangshengControlEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/** Registers vanilla effect mirrors for the eight control categories. */
public final class CangshengEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(Registries.MOB_EFFECT, Cangsheng.MOD_ID);

    public static final DeferredHolder<MobEffect, MobEffect> SLOW = mirror("slow", 0x78909C);
    public static final DeferredHolder<MobEffect, MobEffect> ROOT = mirror("root", 0x546E7A);
    public static final DeferredHolder<MobEffect, MobEffect> SNARE = mirror("snare", 0x455A64);
    public static final DeferredHolder<MobEffect, MobEffect> STUN = mirror("stun", 0xF9A825);
    public static final DeferredHolder<MobEffect, MobEffect> KNOCKDOWN = mirror("knockdown", 0x8D6E63);
    public static final DeferredHolder<MobEffect, MobEffect> SILENCE = mirror("silence", 0x7E57C2);
    public static final DeferredHolder<MobEffect, MobEffect> KNOCKUP = mirror("knockup", 0x42A5F5);
    public static final DeferredHolder<MobEffect, MobEffect> SUPPRESS = mirror("suppress", 0xEF5350);

    private CangshengEffects() {}

    private static DeferredHolder<MobEffect, MobEffect> mirror(String id, int color) {
        return EFFECTS.register(id, () -> new CangshengControlEffect(color));
    }

    public static void register(IEventBus modEventBus) {
        EFFECTS.register(modEventBus);
    }
}
