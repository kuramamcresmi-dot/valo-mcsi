package com.kuramamc.valorant.manager;

import com.kuramamc.valorant.model.agent.Agent;
import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AbilityManager {
    // Oyuncunun seçili ajanını ve yetenek cooldown'larını tutar
    private final Map<UUID, Agent> playerAgents = new HashMap<>();

    public void useAbility(Player player, int slot) {
        Agent agent = playerAgents.get(player.getUniqueId());
        if (agent == null) return;
        
        // Slot bazlı yetenek mantığı (Q, E, C, X tuşları)
        System.out.println(agent.getName() + " yeteneği kullanıldı.");
    }
}
