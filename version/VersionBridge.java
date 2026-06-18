package com.kuramamc.valorant.version;

import org.bukkit.entity.Player;

public interface VersionBridge {

    /**
     * Oyuncuya paket düzeyinde kayıpsız Action Bar mesajı gönderir.
     * (Örn: Mermi sayısı, şarjör durumu veya yetenek durumu için)
     */
    void sendActionBar(Player player, String message);

    /**
     * Oyuncunun kafasının üzerindeki ismi (Nametag) gizler veya özelleştirir.
     * Valorant'taki gibi takım arkadaşlarının birbirini görmesi, düşmanın gizlenmesi için.
     */
    void injectEntityPacket(Player player);
    
    /**
     * Sunucunun NMS sürüm adını döner.
     */
    String getServerVersion();
}
