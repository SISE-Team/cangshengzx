package local.cangsheng.core.registry;

import local.cangsheng.Cangsheng;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

/** Keys for datapack-defined damage types; definitions live under data/cangsheng/damage_type/. */
public final class CangshengDamageTypes {
    public static final ResourceKey<DamageType> PHYSICAL = key("physical");
    public static final ResourceKey<DamageType> SPELL = key("spell");
    public static final ResourceKey<DamageType> TRUE = key("true_damage");

    private CangshengDamageTypes() {}

    private static ResourceKey<DamageType> key(String path) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(Cangsheng.MOD_ID, path));
    }
}
