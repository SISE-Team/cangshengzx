package local.cangsheng.datagen;

import net.minecraft.data.DataProvider;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import com.google.gson.JsonParser;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

/** Small project-owned JSON provider used because legacy model provider helpers are absent. */
abstract class JsonFileProvider implements DataProvider {
    private final Path outputRoot;
    private final PackOutput.Target target;

    JsonFileProvider(PackOutput output, PackOutput.Target target) {
        this.outputRoot = output.getOutputFolder(target);
        this.target = target;
    }

    protected final CompletableFuture<?> write(CachedOutput cache, String relativePath, String json) {
        Path file = outputRoot.resolve(relativePath);
        return DataProvider.saveStable(cache, JsonParser.parseString(json), file);
    }
}
