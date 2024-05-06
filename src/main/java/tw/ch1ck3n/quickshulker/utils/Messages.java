package tw.ch1ck3n.quickshulker.utils;

import org.bukkit.entity.HumanEntity;
import tw.ch1ck3n.quickshulker.QuickShulker;

import java.util.ArrayList;
import java.util.List;

public class Messages {

    public final List<String> help;

    public final String noPermission;

    public final String pluginReloading;

    public final String pluginReloaded;

    public Messages() {
        List<String> temp = new ArrayList<>();
        for (String s: QuickShulker.getInstance().getConfig().getStringList("messages.help")) temp.add(s.replaceAll("&", "§"));
        this.help = temp;
        this.noPermission = QuickShulker.getInstance().getConfig().getString("messages.no-permission").replaceAll("&", "§");
        this.pluginReloading = QuickShulker.getInstance().getConfig().getString("messages.plugin-reloading").replaceAll("&", "§");
        this.pluginReloaded = QuickShulker.getInstance().getConfig().getString("messages.plugin-reloaded").replaceAll("&", "§");

        temp = null;
        System.gc();
    }

    public void send(HumanEntity human, String message) {
        human.sendMessage(QuickShulker.getInstance().prefix + " " + message);
    }
}