package tw.ch1ck3n.quickshulker.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.scheduler.BukkitRunnable;
import tw.ch1ck3n.quickshulker.QuickShulker;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        if (QuickShulker.getInstance().shulkerboxSlot.get(e.getWhoClicked().getUniqueId()) == null) return;

        new BukkitRunnable() {
            @Override
            public void run() {

                Player player = (Player) e.getWhoClicked();

                if (e.getSlot() == QuickShulker.getInstance().shulkerboxSlot.get(player.getUniqueId()) &&
                        e.getSlotType().equals(InventoryType.SlotType.QUICKBAR)) e.setCancelled(true);

                player = null;
                System.gc();
            }
        }.run();
    }
}