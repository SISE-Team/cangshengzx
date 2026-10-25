package local.cangsheng.datagen;

import local.cangsheng.core.registry.CangshengBlocks;
import local.cangsheng.core.registry.CangshengEffects;
import local.cangsheng.core.registry.CangshengItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

/** Language providers for the two supported M0 locales. */
public final class CangshengLanguageProviders {
    private CangshengLanguageProviders() {}

    public static final class ZhCn extends LanguageProvider {
        public ZhCn(PackOutput output) {
            super(output, "cangsheng", "zh_cn");
        }

        @Override
        protected void addTranslations() {
            add("itemGroup.cangsheng", "苍生之下");
            add(CangshengItems.HUANSHANG_TOKEN.get(), "寰裳殿信物");
            add(CangshengItems.CHAOSONG_TOKEN.get(), "朝颂山庄信物");
            add(CangshengItems.QINGMO_TOKEN.get(), "青墨峰信物");
            add(CangshengItems.CANGQIONG_TOKEN.get(), "苍琼堂信物");
            add(CangshengItems.QINGLUAN_TOKEN.get(), "青鸾峰信物");
            add(CangshengItems.FOSI_TOKEN.get(), "佛寺信物");
            add(CangshengItems.DEBUG_WAND.get(), "调试法杖");
            add(CangshengBlocks.SECT_ALTAR.get(), "门派祭坛");
            add(CangshengEffects.SLOW.get(), "迟缓（镜像）");
            add(CangshengEffects.ROOT.get(), "禁锢（镜像）");
            add(CangshengEffects.SNARE.get(), "定身（镜像）");
            add(CangshengEffects.STUN.get(), "眩晕（镜像）");
            add(CangshengEffects.KNOCKDOWN.get(), "击倒（镜像）");
            add(CangshengEffects.SILENCE.get(), "沉默（镜像）");
            add(CangshengEffects.KNOCKUP.get(), "击飞（镜像）");
            add(CangshengEffects.SUPPRESS.get(), "压制（镜像）");
        }
    }

    public static final class EnUs extends LanguageProvider {
        public EnUs(PackOutput output) {
            super(output, "cangsheng", "en_us");
        }

        @Override
        protected void addTranslations() {
            add("itemGroup.cangsheng", "Under Heaven");
            add(CangshengItems.HUANSHANG_TOKEN.get(), "Huanshang Token");
            add(CangshengItems.CHAOSONG_TOKEN.get(), "Chaosong Token");
            add(CangshengItems.QINGMO_TOKEN.get(), "Qingmo Token");
            add(CangshengItems.CANGQIONG_TOKEN.get(), "Cangqiong Token");
            add(CangshengItems.QINGLUAN_TOKEN.get(), "Qingluan Token");
            add(CangshengItems.FOSI_TOKEN.get(), "Fosi Token");
            add(CangshengItems.DEBUG_WAND.get(), "Debug Wand");
            add(CangshengBlocks.SECT_ALTAR.get(), "Sect Altar");
            add(CangshengEffects.SLOW.get(), "Slow (Mirror)");
            add(CangshengEffects.ROOT.get(), "Root (Mirror)");
            add(CangshengEffects.SNARE.get(), "Snare (Mirror)");
            add(CangshengEffects.STUN.get(), "Stun (Mirror)");
            add(CangshengEffects.KNOCKDOWN.get(), "Knockdown (Mirror)");
            add(CangshengEffects.SILENCE.get(), "Silence (Mirror)");
            add(CangshengEffects.KNOCKUP.get(), "Knock-up (Mirror)");
            add(CangshengEffects.SUPPRESS.get(), "Suppression (Mirror)");
        }
    }
}
