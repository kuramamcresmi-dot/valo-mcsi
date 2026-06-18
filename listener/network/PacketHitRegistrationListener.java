package com.kuramamc.valorant.listener.network;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PacketHitRegistrationListener {

    public static void register(JavaPlugin plugin) {
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(
                plugin,
                ListenerPriority.HIGHEST, // Diğer tüm eklentilerin önüne geçmek için
                PacketType.Play.Client.USE_ENTITY
        ) {
            @Override
            public void onPacketReceiving(PacketEvent event) {
                Player attacker = event.getPlayer();
                
                // Paketten yapılan aksiyonu alıyoruz (Saldırı mı, etkileşim mi?)
                EnumWrappers.EntityUseAction action = event.getPacket().getEntityUseActions().read(0);
                if (action != EnumWrappers.EntityUseAction.ATTACK) return;

                // Saldırılan hedef entity'i çekiyoruz
                int targetId = event.getPacket().getIntegers().read(0);
                Entity target = event.getManager().getEntityFromID(attacker.getWorld(), targetId);

                if (target instanceof LivingEntityTarget) {
                    LivingEntity victim = (LivingEntity) target;

                    // MINECRAFT'IN 0.5 SANİYELİK HASAR COOLDOWN'INI SIFIRLIYORUZ
                    // Bu sayede Vandal ile saniyede 10 mermi sıksan bile hepsi hasar kaydeder.
                    plugin.getServer().getScheduler().runTask(plugin, () -> {
                        victim.setNoDamageTicks(0);
                    });
                }
            }
        });
    }
}
