# [FREE] ShulkerBox+ | Use Shulker Boxes like BackPack  

## Overview
+ **Native Minecraft Version: `1.20.4`**  
+ **Tested Minecraft Versions: `1.20.4`**  
+ **Contributors: `Me`**  
+ **Languages Supported: `Customizable`**  

## Commands
+ **/shulkerplus** - Displays a message with a command to use to get list of all commands
+ **/shulkerplus reload** - Reloads the plugin

## Permissions
+ **shulkerplus.open** - Allows player to open ShulkerBox without placing it (True by default)
+ **shulkerplus.admin** - Allow player to use admin commands

## Configuration
```Yaml
# Colors:
#   BLACK = &0, DARK_BLUE = &1, DARK_GREEN = &2, DARK_AQUA = &3
#   DARK_RED = &4, DARK_PURPLE = &5, GOLD = &6, GRAY = &7
#   DARK_GRAY = &8, BLUE = &9, GREEN = &a, AQUA = &b
#   RED = &c, LIGHT_PURPLE = &d, YELLOW = &e, WHITE = &f

# Formats:
#   OBFUSCATED = &k, BOLD = &l, STRIKETHROUGH = &m,
#   UNDERLINE = &n, ITALIC = &o, RESET = &r

messages:
  help:
    - "&e--------- &rHelp: Shulker+ &e---------------------------&r"
    - "&7Below is a list of all Shulker+ commands:&r"
    - "&6/shulkerplus reload: &rReload this plugin"
  no-permission: "&cYou don't have permission to do this!"
  plugin-reloading: "&cReloading plugin..."
  plugin-reloaded: "&aPlugin reloaded!"

settings:
  # 0 for left click, 1 for right click
  interact-button: 1
  # need sneak for opening shulker
  need-sneak: false
```

## Instructions
+ Drag and drop ShulkerPlus plugin into your plugin folder
+ Restart or Reload the server
+ Edit the config and messages files to your needs
+ Reload the plugin (/shulkerplus reload)
+ Enjoy!
