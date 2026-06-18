package com.kuramamc.valorant.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownUtils {
    private static final Map<UUID, Map<String, Long>> cooldowns = new HashMap<>();

    // Belirli bir yetenek için bekleme süresi ayarla
    public static void setCooldown(UUID uuid, String abilityName, int seconds) {
        cooldowns.computeIfAbsent(uuid, k -> new HashMap<>())
                 .put(abilityName, System.currentTimeMillis() + (seconds * 1000L));
    }

    // Yeteneğin süresi doldu mu kontrol et
    public static boolean hasCooldown(UUID uuid, String abilityName) {
        if (!cooldowns.containsKey(uuid) || !cooldowns.get(uuid).containsKey(abilityName)) {
            return false;
        }
        
        long expiry = cooldowns.get(uuid).get(abilityName);
        if (System.currentTimeMillis() > expiry) {
            cooldowns.get(uuid).remove(abilityName);
            return false;
        }
        return true;
    }

    // Kalan süreyi saniye cinsinden al
    public static long getRemainingSeconds(UUID uuid, String abilityName) {
        if (!hasCooldown(uuid, abilityName)) return 0;
        return (cooldowns.get(uuid).get(abilityName) - System.currentTimeMillis()) / 1000;
    }
}
