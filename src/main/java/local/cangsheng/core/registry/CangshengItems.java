package local.cangsheng.core.registry;

import local.cangsheng.Cangsheng;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

/** Registers the six sect placeholders and the non-functional debug wand. */
public final class CangshengItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Cangsheng.MOD_ID);

    public static final DeferredItem<Item> HUANSHANG_TOKEN = ITEMS.registerSimpleItem("huanshang_token");
    public static final DeferredItem<Item> CHAOSONG_TOKEN = ITEMS.registerSimpleItem("chaosong_token");
    public static final DeferredItem<Item> QINGMO_TOKEN = ITEMS.registerSimpleItem("qingmo_token");
    public static final DeferredItem<Item> CANGQIONG_TOKEN = ITEMS.registerSimpleItem("cangqiong_token");
    public static final DeferredItem<Item> QINGLUAN_TOKEN = ITEMS.registerSimpleItem("qingluan_token");
    public static final DeferredItem<Item> FOSI_TOKEN = ITEMS.registerSimpleItem("fosi_token");
    public static final DeferredItem<Item> DEBUG_WAND = ITEMS.registerSimpleItem("debug_wand");

    private CangshengItems() {}

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
