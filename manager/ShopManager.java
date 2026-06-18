package com.kuramamc.valorant.manager;

import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ShopManager {
    private final Map<UUID, Integer> credits = new HashMap<>();

    public void addCredits(UUID uuid, int amount) {
        credits.put(uuid, credits.getOrDefault(uuid, 0) + amount);
    }

    public boolean canAfford(UUID uuid, int cost) {
        return credits.getOrDefault(uuid, 0) >= cost;
    }

    public void openShop(Player player) {
        // Burada Valorant tarzı GUI'yi tetikleyeceğiz
    }
}
