package local.cangsheng.api.skill;

/** Public lifecycle contract for behavior objects bound to skill data. */
public interface SkillBehavior {
    /** Called once when a cast begins. */
    void onCastStart(SkillContext context);

    /** Called on each server tick while a cast is channeling. */
    void onChannelTick(SkillContext context);

    /** Completes the cast and returns its outcome. */
    CastResult onCastComplete(SkillContext context);

    /** Called when the framework interrupts a cast. */
    void onInterrupt(SkillContext context, InterruptReason reason);

    /** Reports whether the behavior-specific cast preconditions are satisfied. */
    boolean canCast(SkillContext context);
}
