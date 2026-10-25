package local.cangsheng.datagen;

import net.minecraft.data.PackOutput;

import java.util.concurrent.CompletableFuture;

/** Writes minimal item and block tags for later recipe and integration use. */
public final class CangshengTagProvider extends JsonFileProvider {
    public CangshengTagProvider(PackOutput output) {
        super(output, PackOutput.Target.DATA_PACK);
    }

    @Override
    public CompletableFuture<?> run(net.minecraft.data.CachedOutput cache) {
        CompletableFuture<?> items = write(cache, "cangsheng/tags/item/sect_tokens.json", """
                {"replace":false,"values":["cangsheng:huanshang_token","cangsheng:chaosong_token","cangsheng:qingmo_token","cangsheng:cangqiong_token","cangsheng:qingluan_token","cangsheng:fosi_token"]}
                """.strip());
        CompletableFuture<?> blocks = write(cache, "cangsheng/tags/block/sect_altars.json", """
                {"replace":false,"values":["cangsheng:sect_altar"]}
                """.strip());
        return CompletableFuture.allOf(items, blocks);
    }

    @Override
    public String getName() {
        return "Cangsheng tags";
    }
}
