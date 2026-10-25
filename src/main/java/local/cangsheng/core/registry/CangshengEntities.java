package local.cangsheng.core.registry;

import local.cangsheng.Cangsheng;
import local.cangsheng.entity.ContractBeastEntity;
import local.cangsheng.entity.MountEntity;
import local.cangsheng.entity.SummonEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/** Registers inert entity types used to establish the M0 registry surface. */
public final class CangshengEntities {
    public static final DeferredRegister.Entities ENTITIES = DeferredRegister.createEntities(Cangsheng.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<ContractBeastEntity>> CONTRACT_BEAST = ENTITIES.registerEntityType(
            "contract_beast", ContractBeastEntity::new, MobCategory.MISC,
            builder -> builder.sized(0.6F, 1.8F));
    public static final DeferredHolder<EntityType<?>, EntityType<MountEntity>> MOUNT = ENTITIES.registerEntityType(
            "mount", MountEntity::new, MobCategory.MISC,
            builder -> builder.sized(1.0F, 1.5F));
    public static final DeferredHolder<EntityType<?>, EntityType<SummonEntity>> SUMMON = ENTITIES.registerEntityType(
            "summon", SummonEntity::new, MobCategory.MISC,
            builder -> builder.sized(0.8F, 1.2F));

    private CangshengEntities() {}

    public static void register(IEventBus modEventBus) {
        ENTITIES.register(modEventBus);
    }
}
