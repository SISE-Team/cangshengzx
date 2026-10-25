package local.cangsheng.datagen;

import net.minecraft.data.DataGenerator;
import net.neoforged.neoforge.data.event.GatherDataEvent;

/** Registers M0 language, model, tag, and recipe data providers. */
public final class CangshengDataGen {
    private CangshengDataGen() {}

    public static void register(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        var output = generator.getPackOutput();
        generator.addProvider(true, new CangshengLanguageProviders.ZhCn(output));
        generator.addProvider(true, new CangshengLanguageProviders.EnUs(output));
        generator.addProvider(true, new CangshengBlockStateProvider(output));
        generator.addProvider(true, new CangshengItemModelProvider(output));
        generator.addProvider(true, new CangshengTagProvider(output));
        generator.addProvider(true, new CangshengRecipeProvider(output));
    }
}
