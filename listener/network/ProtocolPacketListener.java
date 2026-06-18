package com.kuramamc.valorant.listener.network;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ProtocolPacketListener {

    public static void registerPackets(JavaPlugin plugin) {
        // İstemciden gelen el sallama/kullanım paketlerini dinle (Örn: Silah atış stabilizasyonu için)
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(
                plugin,
                ListenerPriority.NORMAL,
                PacketType.Play.Client.USE_ITEM,
                PacketType.Play.Client.ARM_ANIMATION
        ) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                // Silah ateşleme veya sağ tık dürbün (Scope) açma paket manipülasyonları burada işlenecek
                // Örnek: El sallama animasyon paketini iptal ederek silahın titremesini engelleyebilirsin
                if (event.getPacketType() == PacketType.Play.Client.ARM_ANIMATION) {
                    // event.setCancelled(true); // İhtiyaca göre aktif edilir
                }
            }
        });
    }
}
