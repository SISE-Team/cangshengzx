package local.cangsheng.core.attachment;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

/** Serializable placeholder for the player's cultivation and sect selection. */
public record PlayerProfileData(int level, long experience, String realmId, String sectId, String branchId) {
    public static final MapCodec<PlayerProfileData> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            com.mojang.serialization.Codec.INT.fieldOf("level").forGetter(PlayerProfileData::level),
            com.mojang.serialization.Codec.LONG.fieldOf("experience").forGetter(PlayerProfileData::experience),
            com.mojang.serialization.Codec.STRING.fieldOf("realmId").forGetter(PlayerProfileData::realmId),
            com.mojang.serialization.Codec.STRING.fieldOf("sectId").forGetter(PlayerProfileData::sectId),
            com.mojang.serialization.Codec.STRING.fieldOf("branchId").forGetter(PlayerProfileData::branchId)
    ).apply(instance, PlayerProfileData::new));

    public static PlayerProfileData empty() {
        return new PlayerProfileData(0, 0L, "", "", "");
    }
}
