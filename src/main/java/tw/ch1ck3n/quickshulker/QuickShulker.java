package tw.ch1ck3n.quickshulker;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import tw.ch1ck3n.quickshulker.commands.QuickShulkerCmd;
import tw.ch1ck3n.quickshulker.commands.QuickShulkerTab;
import tw.ch1ck3n.quickshulker.listeners.InventoryClickListener;
import tw.ch1ck3n.quickshulker.listeners.InventoryCloseListener;
import tw.ch1ck3n.quickshulker.listeners.PlayerInteractListener;
import tw.ch1ck3n.quickshulker.utils.Messages;
import tw.ch1ck3n.quickshulker.utils.Settings;

import java.util.*;

public final class QuickShulker extends JavaPlugin {

    private static QuickShulker instance;

    public final String prefix = "&7[&aQuickShulker&7]&r".replaceAll("&", "§");

    public Messages messages;

    public Settings settings;

    public Map<UUID, Integer> shulkerboxSlot;

    public static QuickShulker getInstance() {
        return instance;
    }

    public void log(String message) {
        Bukkit.getLogger().info(message);
    }

    @Override
    public void onEnable() {
        instance = this;
        shulkerboxSlot = new HashMap<>();

        this.enable();
    }

    @Override
    public void onDisable() {

    }

    private void enable() {

        this.log("");
        this.log(" > --------------------------------------------- <");
        this.log("");
        this.log("               " + this.getDescription().getName() + " [" + this.getDescription().getVersion() + "]");  // 16 spaces
        this.log("");

        this.setupConfig();

        this.loadConfig();

        this.registerCommands();

        this.registerListeners();

        this.log("");
        this.log(" > --------------------------------------------- <");
        this.log("");
    }

    private void setupConfig() {

        this.log("  > Saving default config");

        this.saveDefaultConfig();

        this.log("    ...default config saved");
    }

    private void loadConfig() {

        this.log("  > Loading config");

        this.messages = new Messages();
        this.settings = new Settings();

        this.log("    ...config loaded");
    }

    Map<String, CommandExecutor> commands = new HashMap<String, CommandExecutor>() {{
        put("quickshulker", new QuickShulkerCmd());
    }};

    Map<String, TabCompleter> tabs = new HashMap<String, TabCompleter>() {{
        put("quickshulker", new QuickShulkerTab());
    }};

    private void registerCommands() {

        this.log("  > Registering commands");
        int count = 0;

        for (Map.Entry<String, CommandExecutor> command : commands.entrySet()) {
            this.getCommand(command.getKey()).setExecutor(command.getValue());
            count++;
        }

        for (Map.Entry<String, TabCompleter> tab : tabs.entrySet()) {
            this.getCommand(tab.getKey()).setTabCompleter(tab.getValue());
        }

        this.log("    ...registered " + count + " command(s)");
    }

    ArrayList<Object> listeners = new ArrayList<Object>() {{
        add(new InventoryClickListener());
        add(new InventoryCloseListener());
        add(new PlayerInteractListener());
    }};

    private void registerListeners() {

        this.log("  > Registering listeners");
        int count = 0;

        for (Object listener: listeners) {
            this.getServer().getPluginManager().registerEvents((Listener) listener, this);
            count++;
        }

        this.log("    ...registered " + count + " listener(s)");
    }

}
