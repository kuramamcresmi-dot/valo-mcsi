package com.kuramamc.valorant.listener.network;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class PacketBlockPlacementBlocker {

    public static void register(JavaPlugin plugin) {
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(
                plugin,
                ListenerPriority.NORMAL,
                PacketType.Play.Client.BLOCK_PLACE
        ) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                Player player = event.getPlayer();
                ItemStack item = player.getInventory().getItemInMainHand();

                // Eğer oyuncunun elinde silah veya özel bir eşya varsa (Örn: Kazma, Blok değilse)
                // Sağ tıklandığında sunucuya giden blok koyma paketini tamamen iptal et.
                if (item != null && item.getType() != Material.AIR && !item.getType().isBlock()) {
                    
                    // Paketi iptal et: İstemci sunucuya blok yerleştiremeyeceğini anlar.
                    event.setCancelled(true);
                }
            }
        });
    }
}
