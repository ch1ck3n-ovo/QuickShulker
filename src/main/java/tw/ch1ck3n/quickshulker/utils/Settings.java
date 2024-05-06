package tw.ch1ck3n.quickshulker.utils;

import org.bukkit.event.block.Action;
import tw.ch1ck3n.quickshulker.QuickShulker;

public class Settings {

    public final Action interactButton;

    public final boolean needSneak;

    public Settings() {
        int button = QuickShulker.getInstance().getConfig().getInt("settings.interact-button");
        this.interactButton = (button == 0 ? Action.LEFT_CLICK_AIR : Action.RIGHT_CLICK_AIR);
        this.needSneak = QuickShulker.getInstance().getConfig().getBoolean("settings.need-sneak");
    }

}
