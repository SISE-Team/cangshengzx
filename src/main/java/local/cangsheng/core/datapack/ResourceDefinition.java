package local.cangsheng.core.datapack;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

/** Data-only resource declaration; updates and resource-pool behavior are future work. */
public record ResourceDefinition(String id, String sect, String displayName, int max, String shape) {
    public static final Codec<ResourceDefinition> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("id").forGetter(ResourceDefinition::id),
            Codec.STRING.fieldOf("sect").forGetter(ResourceDefinition::sect),
            Codec.STRING.fieldOf("displayName").forGetter(ResourceDefinition::displayName),
            Codec.INT.optionalFieldOf("max", -1).forGetter(ResourceDefinition::max),
            Codec.STRING.fieldOf("shape").forGetter(ResourceDefinition::shape)
    ).apply(instance, ResourceDefinition::new));
}
