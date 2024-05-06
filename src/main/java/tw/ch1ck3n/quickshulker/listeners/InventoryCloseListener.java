package tw.ch1ck3n.quickshulker.listeners;

import org.bukkit.Sound;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.scheduler.BukkitRunnable;
import tw.ch1ck3n.quickshulker.QuickShulker;

public class InventoryCloseListener implements Listener {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {

        if (QuickShulker.getInstance().shulkerboxSlot.get(e.getPlayer().getUniqueId()) == null) return;

        new BukkitRunnable() {
            @Override
            public void run() {

                Player player = (Player) e.getPlayer();
                ItemStack item = player.getInventory().getItem(QuickShulker.getInstance().shulkerboxSlot.get(player.getUniqueId()));
                BlockStateMeta blockStateMeta = (BlockStateMeta) item.getItemMeta();
                ShulkerBox shulkerbox = (ShulkerBox) blockStateMeta.getBlockState();

                shulkerbox.getInventory().setContents(e.getInventory().getContents());
                blockStateMeta.setBlockState(shulkerbox);
                item.setItemMeta(blockStateMeta);
                QuickShulker.getInstance().shulkerboxSlot.remove(e.getPlayer().getUniqueId());
                player.getWorld().playSound(player.getLocation(), Sound.BLOCK_SHULKER_BOX_CLOSE, .1F, 1.0F);

                player = null;
                item = null;
                blockStateMeta = null;
                shulkerbox = null;
                System.gc();
            }
        }.runTask(QuickShulker.getInstance());
    }
}