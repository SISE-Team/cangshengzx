package local.cangsheng.core.registry;

import local.cangsheng.Cangsheng;
import local.cangsheng.core.datapack.RealmDefinition;
import local.cangsheng.core.datapack.ResourceDefinition;
import local.cangsheng.core.datapack.SectDefinition;
import local.cangsheng.core.datapack.SkillDefinition;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

/** Declares the four codec-backed datapack registries used by the content pipeline. */
public final class CangshengDataRegistries {
    public static final ResourceKey<Registry<SectDefinition>> SECTS = registryKey("sect");
    public static final ResourceKey<Registry<SkillDefinition>> SKILLS = registryKey("skill");
    public static final ResourceKey<Registry<RealmDefinition>> REALMS = registryKey("realm");
    public static final ResourceKey<Registry<ResourceDefinition>> RESOURCES = registryKey("resource");

    private CangshengDataRegistries() {}

    private static <T> ResourceKey<Registry<T>> registryKey(String path) {
        return ResourceKey.createRegistryKey(Identifier.fromNamespaceAndPath(Cangsheng.MOD_ID, path));
    }

    public static void register(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(SECTS, SectDefinition.CODEC);
        event.dataPackRegistry(SKILLS, SkillDefinition.CODEC);
        event.dataPackRegistry(REALMS, RealmDefinition.CODEC);
        event.dataPackRegistry(RESOURCES, ResourceDefinition.CODEC);
    }
}
