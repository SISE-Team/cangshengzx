package local.cangsheng.core.datapack;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;
import java.util.Map;

/** Data-only skill card shape. Behavior ids are intentionally unresolved in M0. */
public record SkillDefinition(
        String sect,
        String branch,
        String tier,
        String realm,
        String role,
        String name,
        double cooldown,
        Map<String, Double> cost,
        Cast cast,
        Requirements require,
        Targeting targeting,
        Movement movement,
        List<String> breaker,
        String behavior
) {
    public static final Codec<SkillDefinition> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.fieldOf("sect").forGetter(SkillDefinition::sect),
            Codec.STRING.fieldOf("branch").forGetter(SkillDefinition::branch),
            Codec.STRING.fieldOf("tier").forGetter(SkillDefinition::tier),
            Codec.STRING.fieldOf("realm").forGetter(SkillDefinition::realm),
            Codec.STRING.fieldOf("role").forGetter(SkillDefinition::role),
            Codec.STRING.fieldOf("name").forGetter(SkillDefinition::name),
            Codec.DOUBLE.fieldOf("cooldown").forGetter(SkillDefinition::cooldown),
            Codec.unboundedMap(Codec.STRING, Codec.DOUBLE).fieldOf("cost").forGetter(SkillDefinition::cost),
            Cast.CODEC.fieldOf("cast").forGetter(SkillDefinition::cast),
            Requirements.CODEC.fieldOf("require").forGetter(SkillDefinition::require),
            Targeting.CODEC.fieldOf("targeting").forGetter(SkillDefinition::targeting),
            Movement.CODEC.fieldOf("movement").forGetter(SkillDefinition::movement),
            Codec.STRING.listOf().fieldOf("breaker").forGetter(SkillDefinition::breaker),
            Codec.STRING.fieldOf("behavior").forGetter(SkillDefinition::behavior)
    ).apply(instance, SkillDefinition::new));

    public record Cast(double time, boolean movable, boolean interruptible) {
        public static final Codec<Cast> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.DOUBLE.fieldOf("time").forGetter(Cast::time),
                Codec.BOOL.fieldOf("movable").forGetter(Cast::movable),
                Codec.BOOL.fieldOf("interruptible").forGetter(Cast::interruptible)
        ).apply(instance, Cast::new));
    }

    public record Requirements(Map<String, Double> selfResource, Map<String, Double> targetStatus,
                               Map<String, Double> selfStatus) {
        public static final Codec<Requirements> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.unboundedMap(Codec.STRING, Codec.DOUBLE).fieldOf("selfResource")
                        .forGetter(Requirements::selfResource),
                Codec.unboundedMap(Codec.STRING, Codec.DOUBLE).fieldOf("targetStatus")
                        .forGetter(Requirements::targetStatus),
                Codec.unboundedMap(Codec.STRING, Codec.DOUBLE).fieldOf("selfStatus")
                        .forGetter(Requirements::selfStatus)
        ).apply(instance, Requirements::new));
    }

    public record Targeting(String shape) {
        public static final Codec<Targeting> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.STRING.fieldOf("shape").forGetter(Targeting::shape)
        ).apply(instance, Targeting::new));
    }

    public record Movement(boolean lock, boolean cancelable) {
        public static final Codec<Movement> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.BOOL.fieldOf("lock").forGetter(Movement::lock),
                Codec.BOOL.fieldOf("cancelable").forGetter(Movement::cancelable)
        ).apply(instance, Movement::new));
    }
}
