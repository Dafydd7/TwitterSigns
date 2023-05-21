package org.dafy.twittersigns.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Dependency;
import co.aikar.commands.annotation.Subcommand;

import org.bukkit.entity.Player;
import org.dafy.twittersigns.TwitterSigns;

@CommandAlias("twitter")
public class Reset extends BaseCommand {
    @Dependency
    private TwitterSigns plugin;
    @Subcommand("reset")
    @CommandPermission("twittersigns.commands.admin.reset")
    public void signReset(Player player){
        player.sendMessage("Twitter: config reset.");
        plugin.getConfig().set("Sign-Found",false);
        plugin.getConfig().set("Winner-Name",null);
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
    }
}
