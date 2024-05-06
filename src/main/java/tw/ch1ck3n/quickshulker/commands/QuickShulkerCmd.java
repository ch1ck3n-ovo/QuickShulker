package tw.ch1ck3n.quickshulker.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import tw.ch1ck3n.quickshulker.QuickShulker;
import tw.ch1ck3n.quickshulker.utils.Messages;

public class QuickShulkerCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player) if (!sender.hasPermission("shulkerplus.admin")) return true;

        new BukkitRunnable() {
            @Override
            public void run() {

                Messages messages = QuickShulker.getInstance().messages;

                if (args.length == 1) {
                    if (args[0].equals("reload")) {
                        if (sender instanceof Player) {
                            messages.send((HumanEntity) sender, messages.pluginReloading);
                        }

                        QuickShulker.getInstance().onDisable();
                        QuickShulker.getInstance().onEnable();

                        if (sender instanceof Player) {
                            messages.send((HumanEntity) sender, messages.pluginReloaded);
                        }
                    } else {
                        for (String s: messages.help) sender.sendMessage(s);
                    }
                } else {
                    for (String s: messages.help) sender.sendMessage(s);
                }
            }
        }.runTask(QuickShulker.getInstance());

        return true;
    }
}
