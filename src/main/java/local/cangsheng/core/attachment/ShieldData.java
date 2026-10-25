package local.cangsheng.core.attachment;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

/** Serializable placeholder for the three shield layers. */
public record ShieldData(double physical, double magical, double universal) {
    public static final MapCodec<ShieldData> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.DOUBLE.fieldOf("physical").forGetter(ShieldData::physical),
            Codec.DOUBLE.fieldOf("magical").forGetter(ShieldData::magical),
            Codec.DOUBLE.fieldOf("universal").forGetter(ShieldData::universal)
    ).apply(instance, ShieldData::new));

    public static ShieldData empty() {
        return new ShieldData(0.0D, 0.0D, 0.0D);
    }
}
