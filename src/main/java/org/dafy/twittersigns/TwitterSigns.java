package org.dafy.twittersigns;

import co.aikar.commands.BukkitCommandManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.dafy.twittersigns.Commands.Reload;
import org.dafy.twittersigns.Commands.Reset;
import org.dafy.twittersigns.Listeners.SignListener;

public final class TwitterSigns extends JavaPlugin {

    @Override    public void onEnable() {
        BukkitCommandManager manager = new BukkitCommandManager(this);
        manager.registerCommand(new Reset());
        manager.registerCommand(new Reload());

        getServer().getPluginManager().registerEvents(new SignListener(this),this);
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    @Override
    public void onDisable() {
        saveConfig();
    }
}
