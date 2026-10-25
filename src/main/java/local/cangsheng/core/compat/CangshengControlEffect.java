package local.cangsheng.core.compat;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

/** Vanilla-visible mirror only; authoritative control state lives elsewhere. */
public final class CangshengControlEffect extends MobEffect {
    public CangshengControlEffect(int color) {
        super(MobEffectCategory.HARMFUL, color);
    }
}
