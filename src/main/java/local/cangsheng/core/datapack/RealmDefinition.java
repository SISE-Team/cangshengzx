package local.cangsheng.core.datapack;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

/** Data-only realm row matching the ten-realm setting table. */
public record RealmDefinition(String id, String name, int minLevel, int maxLevel, String lifespan, String mark) {
    public static final Codec<RealmDefinition> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("id").forGetter(RealmDefinition::id),
            Codec.STRING.fieldOf("name").forGetter(RealmDefinition::name),
            Codec.INT.fieldOf("minLevel").forGetter(RealmDefinition::minLevel),
            Codec.INT.fieldOf("maxLevel").forGetter(RealmDefinition::maxLevel),
            Codec.STRING.fieldOf("lifespan").forGetter(RealmDefinition::lifespan),
            Codec.STRING.fieldOf("mark").forGetter(RealmDefinition::mark)
    ).apply(instance, RealmDefinition::new));
}
