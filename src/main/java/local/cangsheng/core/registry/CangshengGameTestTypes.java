package local.cangsheng.core.registry;

import com.mojang.serialization.MapCodec;
import local.cangsheng.Cangsheng;
import local.cangsheng.core.event.CangshengGameTests;
import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTestInstance;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

/** Registers the custom GameTestInstance codec so test registries can synchronize to clients. */
public final class CangshengGameTestTypes {
    public static final DeferredRegister<MapCodec<? extends GameTestInstance>> TYPES =
            DeferredRegister.create(Registries.TEST_INSTANCE_TYPE, Cangsheng.MOD_ID);

    static {
        TYPES.register("registry_smoke", () -> CangshengGameTests.RegistrySmokeTest.CODEC);
    }

    private CangshengGameTestTypes() {}

    public static void register(IEventBus modEventBus) {
        TYPES.register(modEventBus);
    }
}
