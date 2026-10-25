package local.cangsheng.core.attachment;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;

import java.util.Map;

/** Serializable placeholder for control-category diminishing-return timers. */
public record ControlTimerData(Map<String, Integer> remainingTicks) {
    public static final MapCodec<ControlTimerData> CODEC = Codec.unboundedMap(Codec.STRING, Codec.INT)
            .fieldOf("remainingTicks").xmap(ControlTimerData::new, ControlTimerData::remainingTicks);

    public static ControlTimerData empty() {
        return new ControlTimerData(Map.of());
    }
}
