package local.cangsheng.core.registry;

import local.cangsheng.Cangsheng;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/** Registers combat attribute handles; combat calculations are intentionally absent in M0. */
public final class CangshengAttributes {
    private static final double MAX_ATTRIBUTE = 1_000_000.0D;
    public static final DeferredRegister<Attribute> ATTRIBUTES =
            DeferredRegister.create(Registries.ATTRIBUTE, Cangsheng.MOD_ID);

    public static final DeferredHolder<Attribute, Attribute> SPELL_DEFENSE = attribute("spell_defense", 0.0D);
    public static final DeferredHolder<Attribute, Attribute> ARMOR_PENETRATION = attribute("armor_penetration", 0.0D);
    public static final DeferredHolder<Attribute, Attribute> CRITICAL_CHANCE = attribute("critical_chance", 0.0D);
    public static final DeferredHolder<Attribute, Attribute> CRITICAL_DAMAGE = attribute("critical_damage", 1.5D);
    public static final DeferredHolder<Attribute, Attribute> HASTE = attribute("haste", 0.0D);

    private CangshengAttributes() {}

    private static DeferredHolder<Attribute, Attribute> attribute(String id, double defaultValue) {
        return ATTRIBUTES.register(id, () -> new RangedAttribute(
                "attribute.name.cangsheng." + id, defaultValue, 0.0D, MAX_ATTRIBUTE).setSyncable(true));
    }

    public static void register(IEventBus modEventBus) {
        ATTRIBUTES.register(modEventBus);
    }
}
