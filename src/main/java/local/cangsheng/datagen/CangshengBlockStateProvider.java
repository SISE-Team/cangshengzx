package local.cangsheng.datagen;

import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

/** Writes the single-state altar blockstate JSON. */
public final class CangshengBlockStateProvider extends JsonFileProvider {
    public CangshengBlockStateProvider(PackOutput output) {
        super(output, PackOutput.Target.RESOURCE_PACK);
    }

    @Override
    public CompletableFuture<?> run(net.minecraft.data.CachedOutput cache) {
        return write(cache, "cangsheng/blockstates/sect_altar.json", """
                {"variants":{"":{"model":"cangsheng:block/sect_altar"}}}
                """.strip());
    }

    @Override
    public String getName() {
        return "Cangsheng blockstates";
    }
}
