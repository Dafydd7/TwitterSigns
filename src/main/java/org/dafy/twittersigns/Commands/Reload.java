package org.dafy.twittersigns.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Dependency;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.entity.Player;
import org.dafy.twittersigns.TwitterSigns;

@CommandAlias("twitter")
public class Reload extends BaseCommand {
    @Dependency
    private TwitterSigns plugin;
    @Subcommand("reload")
    @CommandPermission("twittersigns.commands.admin.reload")
    public void commandReload(Player player){
        plugin.saveConfig();
        player.sendMessage("Twitter: config reloaded.");
    }

}
