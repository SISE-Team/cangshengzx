package local.cangsheng.core.registry;

import local.cangsheng.Cangsheng;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/** Registers two inert simple particle types for later client rendering. */
public final class CangshengParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES =
            DeferredRegister.create(Registries.PARTICLE_TYPE, Cangsheng.MOD_ID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PETAL_SPARK =
            PARTICLES.register("petal_spark", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> THUNDER_FLASH =
            PARTICLES.register("thunder_flash", () -> new SimpleParticleType(false));

    private CangshengParticles() {}

    public static void register(IEventBus modEventBus) {
        PARTICLES.register(modEventBus);
    }
}
