package local.cangsheng.core.registry;

import com.mojang.serialization.Codec;
import local.cangsheng.Cangsheng;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.Map;

/** Registers persistent data component types without implementing their gameplay use. */
public final class CangshengDataComponents {
    public static final DeferredRegister.DataComponents COMPONENTS =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Cangsheng.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<String>>> WEAPON_AFFIXES =
            COMPONENTS.registerComponentType("weapon_affixes", builder -> builder
                    .persistent(Codec.STRING.listOf()));
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Map<String, Double>>> RESOURCE_CONTAINER =
            COMPONENTS.registerComponentType("resource_container", builder -> builder
                    .persistent(Codec.unboundedMap(Codec.STRING, Codec.DOUBLE)));

    private CangshengDataComponents() {}

    public static void register(IEventBus modEventBus) {
        COMPONENTS.register(modEventBus);
    }
}
