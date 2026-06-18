package com.kuramamc.valorant.listener.game;

import com.kuramamc.valorant.manager.GameManager;
import com.kuramamc.valorant.model.game.TeamType;
import com.kuramamc.valorant.util.TextUtils;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player victim = event.getEntity();
        Player killer = victim.getKiller();

        // Varsayılan minecraft ölüm mesajını gizle
        event.setDeathMessage(null);

        // Valorant tarzı kill bildirimi kurgusu
        if (killer != null) {
            killer.sendMessage(TextUtils.colorString("&a⚔ &f" + victim.getName() + " &7oyuncusunu etkisiz hale getirdin!"));
            victim.sendMessage(TextUtils.colorString("&c☠ &e" + killer.getName() + " &7tarafından öldürüldün."));
        }

        // Oyuncuyu öldüğü an izleyici moduna al (Valorant tur mantığı)
        victim.setGameMode(GameMode.SPECTATOR);
        
        // İleride GameManager üzerinden turun bitip bitmediğini kontrol eden fonksiyon buraya bağlanacak
    }
}
