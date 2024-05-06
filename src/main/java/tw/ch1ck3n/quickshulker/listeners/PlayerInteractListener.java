package tw.ch1ck3n.quickshulker.listeners;

import org.bukkit.Sound;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import tw.ch1ck3n.quickshulker.QuickShulker;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        if (!e.getAction().equals(QuickShulker.getInstance().settings.interactButton)) return;
        if (e.getPlayer().isSneaking() != QuickShulker.getInstance().settings.needSneak) return;
        if (!isShulkerBox(e.getItem())) return;

        if (!e.getPlayer().hasPermission(new Permission("shulkerboxplus.open", PermissionDefault.TRUE))) {
            QuickShulker.getInstance().messages.send(e.getPlayer(), QuickShulker.getInstance().messages.noPermission);
            return;
        }

        Player player = e.getPlayer();
        ShulkerBox shulkerbox = (ShulkerBox) ((BlockStateMeta) e.getItem().getItemMeta()).getBlockState();
        Inventory inventory = shulkerbox.getInventory();

        player.openInventory(inventory);
        QuickShulker.getInstance().shulkerboxSlot.put(player.getUniqueId(), player.getInventory().getHeldItemSlot());
        player.getWorld().playSound(player.getLocation(), Sound.BLOCK_SHULKER_BOX_OPEN, .1F, 1.0F);
        e.setCancelled(true);

        player = null;
        shulkerbox = null;
        inventory = null;
        System.gc();
    }

    private boolean isShulkerBox(ItemStack item) {
        return item.getType().name().contains("SHULKER_BOX");
    }
}