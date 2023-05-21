package org.dafy.twittersigns.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.dafy.twittersigns.TwitterSigns;

public class SignListener implements Listener {
    private final TwitterSigns plugin;
    public SignListener(TwitterSigns plugin){
        this.plugin = plugin;

    }
    @EventHandler
    public void onRightClick(PlayerInteractEvent e){
        if(e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if(e.getClickedBlock() == null) return;
        if (!(e.getClickedBlock().getState() instanceof Sign)) return;

        Sign sign = (Sign) e.getClickedBlock().getState();
            if(sign.getLine(1).equals(plugin.getConfig().getString("Sign-Code"))){
                if(plugin.getConfig().getBoolean("Sign-Found")) return;

                Player player = e.getPlayer();
                String playerName = player.getName();
                player.sendMessage("§aCongratulations, you have found the sign!"
                + "\n §b↪§fTo claim, please make a ticket on our discord!");
                plugin.getConfig().set("Sign-Found",true);
                plugin.getConfig().set("Winner-Name", playerName);
                plugin.saveConfig();
            }
    }
}
