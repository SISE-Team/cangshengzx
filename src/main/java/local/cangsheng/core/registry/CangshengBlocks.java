package local.cangsheng.core.registry;

import local.cangsheng.Cangsheng;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

/** Registers the shared placeholder altar block and its block item. */
public final class CangshengBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Cangsheng.MOD_ID);
    public static final DeferredBlock<Block> SECT_ALTAR = BLOCKS.registerSimpleBlock(
            "sect_altar", properties -> properties.strength(2.0F));

    static {
        CangshengItems.ITEMS.registerSimpleBlockItem(SECT_ALTAR);
    }

    private CangshengBlocks() {}

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
