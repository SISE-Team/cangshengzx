package local.cangsheng.core.datapack;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;

/** Data-only sect descriptor for the datapack registry. */
public record SectDefinition(
        String id,
        String displayName,
        String verse,
        String primaryColor,
        List<BranchDefinition> branches,
        List<String> resources
) {
    public static final Codec<SectDefinition> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("id").forGetter(SectDefinition::id),
            Codec.STRING.fieldOf("displayName").forGetter(SectDefinition::displayName),
            Codec.STRING.fieldOf("verse").forGetter(SectDefinition::verse),
            Codec.STRING.fieldOf("primaryColor").forGetter(SectDefinition::primaryColor),
            BranchDefinition.CODEC.listOf().fieldOf("branches").forGetter(SectDefinition::branches),
            Codec.STRING.listOf().fieldOf("resources").forGetter(SectDefinition::resources)
    ).apply(instance, SectDefinition::new));

    public record BranchDefinition(String id, String title, String type) {
        public static final Codec<BranchDefinition> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.STRING.fieldOf("id").forGetter(BranchDefinition::id),
                Codec.STRING.fieldOf("title").forGetter(BranchDefinition::title),
                Codec.STRING.fieldOf("type").forGetter(BranchDefinition::type)
        ).apply(instance, BranchDefinition::new));
    }
}
