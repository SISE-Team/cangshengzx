package local.cangsheng.api.combat;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;

/** Immutable input snapshot passed between future damage-pipeline phases. */
public record DamageContext(DamageSource source, Entity target, float amount, DamagePhase phase) {}
