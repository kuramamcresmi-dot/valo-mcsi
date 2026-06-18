package com.kuramamc.valorant.util;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.entity.Player;

public class PacketUtils {

    // İleride buraya PacketContainer ile mermi izi (Particle) 
    // veya ekran sarsıntısı kodlarını ekleyeceğiz.
    public static void sendPacket(Player player, PacketContainer packet) {
        try {
            ProtocolLibrary.getProtocolManager().sendServerPacket(player, packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
