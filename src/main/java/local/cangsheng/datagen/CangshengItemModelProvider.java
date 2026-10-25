package local.cangsheng.datagen;

import net.minecraft.data.PackOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/** Writes simple generated-item models and the altar's cube model. */
public final class CangshengItemModelProvider extends JsonFileProvider {
    private static final List<String> ITEMS = List.of(
            "huanshang_token", "chaosong_token", "qingmo_token", "cangqiong_token",
            "qingluan_token", "fosi_token", "debug_wand");

    public CangshengItemModelProvider(PackOutput output) {
        super(output, PackOutput.Target.RESOURCE_PACK);
    }

    @Override
    public CompletableFuture<?> run(net.minecraft.data.CachedOutput cache) {
        List<CompletableFuture<?>> writes = new ArrayList<>();
        for (String item : ITEMS) {
            writes.add(write(cache, "cangsheng/models/item/" + item + ".json",
                    "{\"parent\":\"minecraft:item/generated\",\"textures\":{\"layer0\":\"cangsheng:item/" + item + "\"}}"));
            writes.add(write(cache, "cangsheng/items/" + item + ".json",
                    "{\"model\":{\"type\":\"minecraft:model\",\"model\":\"cangsheng:item/" + item + "\"}}"));
        }
        writes.add(write(cache, "cangsheng/models/block/sect_altar.json",
                "{\"parent\":\"minecraft:block/cube_all\",\"textures\":{\"all\":\"minecraft:block/stone\"}}"));
        writes.add(write(cache, "cangsheng/items/sect_altar.json",
                "{\"model\":{\"type\":\"minecraft:model\",\"model\":\"cangsheng:block/sect_altar\"}}"));
        return CompletableFuture.allOf(writes.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName() {
        return "Cangsheng item and block models";
    }
}
