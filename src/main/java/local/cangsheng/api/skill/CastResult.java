package local.cangsheng.api.skill;

/** Result descriptor returned after a skill behavior completes. */
public record CastResult(boolean successful, String reason) {
}
