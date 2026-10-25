package local.cangsheng.api.skill;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

import java.util.Optional;

/** Read-only server context supplied to a skill behavior by the future skill framework. */
public interface SkillContext {
    /** Returns the player who initiated the cast. */
    ServerPlayer caster();

    /** Returns the selected target when the skill has one. */
    Optional<Entity> target();
}
