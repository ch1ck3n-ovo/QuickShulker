package tw.ch1ck3n.quickshulker.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class QuickShulkerTab implements TabCompleter {

    ArrayList<String> aliases = new ArrayList<String>() {{
        add("shulkerplus");
        add("sp");
    }};

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {

        List<String> list = new ArrayList<>();

        if (commandSender instanceof Player) if (!commandSender.hasPermission("shulkerplus.admin")) return list;

        new BukkitRunnable() {
            @Override
            public void run() {

                if (commandSender instanceof Player) {
                    if (aliases.contains(command.getName())) {
                        if (strings.length == 1) {
                            String subs[] = {"reload"};

                            for (int i = 0; i < subs.length; i++) {
                                if (subs[i].startsWith(strings[0])) list.add(subs[i]);
                            }
                        }
                    }
                }
            }
        }.run();

        return list;
    }
}
