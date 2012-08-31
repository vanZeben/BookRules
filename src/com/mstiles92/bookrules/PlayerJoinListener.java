package com.mstiles92.bookrules;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerJoinListener implements Listener {
	private final BookRulesPlugin plugin;
	
	public PlayerJoinListener(BookRulesPlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void OnPlayerJoin(PlayerLoginEvent e) {
		if (e.getPlayer().hasPlayedBefore() || !plugin.getConfig().getBoolean("Give-Books-On-First-Join")) {
			return;
		}
		
		plugin.giveAllBooks(e.getPlayer());
		e.getPlayer().sendMessage(plugin.tag + plugin.getConfig().getString("Welcome-Message"));
	}

}
