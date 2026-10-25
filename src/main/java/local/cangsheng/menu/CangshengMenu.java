package local.cangsheng.menu;

import local.cangsheng.core.registry.CangshengMenus;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

/** Inert menu placeholder; it intentionally contains no slots in M0. */
public final class CangshengMenu extends AbstractContainerMenu {
    public CangshengMenu(int containerId, Inventory inventory) {
        super(CangshengMenus.SKILL_CONFIG.get(), containerId);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slotIndex) {
        return ItemStack.EMPTY;
    }
}
