package com.kuramamc.valorant.listener.game;

import com.kuramamc.valorant.manager.PlayerManager;
import com.kuramamc.valorant.util.TextUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        
        // Bellek sızıntısını önlemek için veriyi sil
        PlayerManager.getInstance().unloadPlayerData(player.getUniqueId());
        
        event.setQuitMessage(TextUtils.colorString("&8[&c-&8] &7" + player.getName() + " &fayrıldı."));
    }
}
