package local.cangsheng.core.registry;

import local.cangsheng.Cangsheng;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/** Registers named sound events; M0 intentionally supplies no audio assets. */
public final class CangshengSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS =
            DeferredRegister.create(Registries.SOUND_EVENT, Cangsheng.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> SKILL_CAST = sound("skill_cast");
    public static final DeferredHolder<SoundEvent, SoundEvent> REALM_BREAKTHROUGH = sound("realm_breakthrough");
    public static final DeferredHolder<SoundEvent, SoundEvent> CONTROL_HIT = sound("control_hit");

    private CangshengSounds() {}

    private static DeferredHolder<SoundEvent, SoundEvent> sound(String id) {
        return SOUNDS.register(id, () -> SoundEvent.createVariableRangeEvent(
                net.minecraft.resources.Identifier.fromNamespaceAndPath(Cangsheng.MOD_ID, id)));
    }

    public static void register(IEventBus modEventBus) {
        SOUNDS.register(modEventBus);
    }
}
