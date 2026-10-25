package local.cangsheng.datagen;

import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

/** Writes a deliberately trivial recipe placeholder for the shared altar. */
public final class CangshengRecipeProvider extends JsonFileProvider {
    public CangshengRecipeProvider(PackOutput output) {
        super(output, PackOutput.Target.DATA_PACK);
    }

    @Override
    public CompletableFuture<?> run(net.minecraft.data.CachedOutput cache) {
        return write(cache, "cangsheng/recipe/sect_altar.json", """
                {"type":"minecraft:crafting_shaped","category":"building","key":{"#":"minecraft:stone"},"pattern":["#"],"result":{"count":1,"id":"cangsheng:sect_altar"}}
                """.strip());
    }

    @Override
    public String getName() {
        return "Cangsheng placeholder recipe";
    }
}
