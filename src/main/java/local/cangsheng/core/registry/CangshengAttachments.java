package local.cangsheng.core.registry;

import local.cangsheng.Cangsheng;
import local.cangsheng.core.attachment.ControlTimerData;
import local.cangsheng.core.attachment.PlayerProfileData;
import local.cangsheng.core.attachment.ShieldData;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/** Registers persistent data attachments; state updates and sync are future work. */
public final class CangshengAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS =
            DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, Cangsheng.MOD_ID);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<PlayerProfileData>> PLAYER_PROFILE =
            ATTACHMENTS.register("player_profile", () -> AttachmentType.builder(PlayerProfileData::empty)
                    .serialize(PlayerProfileData.CODEC).build());
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<ShieldData>> SHIELDS =
            ATTACHMENTS.register("shields", () -> AttachmentType.builder(ShieldData::empty)
                    .serialize(ShieldData.CODEC).build());
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<ControlTimerData>> CONTROL_TIMERS =
            ATTACHMENTS.register("control_timers", () -> AttachmentType.builder(ControlTimerData::empty)
                    .serialize(ControlTimerData.CODEC).build());

    private CangshengAttachments() {}

    public static void register(IEventBus modEventBus) {
        ATTACHMENTS.register(modEventBus);
    }
}
