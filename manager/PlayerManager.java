package com.kuramamc.valorant.manager;

import com.kuramamc.valorant.model.agent.PlayerData;
import com.kuramamc.valorant.util.ProfanityFilter;
import com.kuramamc.valorant.util.TextUtils;
import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerManager {
    private static PlayerManager instance;
    private final Map<UUID, PlayerData> playerDataMap = new HashMap<>();

    private PlayerManager() {}

    public static PlayerManager getInstance() {
        if (instance == null) {
            instance = new PlayerManager();
        }
        return instance;
    }

    /**
     * Oyuncu sunucuya katıldığında verisini belleğe yükler.
     */
    public void loadPlayerData(UUID uuid, String mcName) {
        if (!playerDataMap.containsKey(uuid)) {
            playerDataMap.put(uuid, new PlayerData(uuid, mcName));
        }
    }

    /**
     * Oyuncu sunucudan ayrıldığında bellek sızıntısını (Memory Leak) önlemek için veriyi temizler.
     */
    public void unloadPlayerData(UUID uuid) {
        playerDataMap.remove(uuid);
    }

    /**
     * Belirtilen UUID'ye ait oyuncu verisini döner.
     */
    public PlayerData getPlayerData(UUID uuid) {
        return playerDataMap.get(uuid);
    }

    /**
     * Oyuncunun Valorant etiketini (#TAG) güvenli bir şekilde günceller.
     * Küfür filtresi ve karakter sınırı kontrollerini içerir.
     */
    public boolean updatePlayerTag(Player player, String newTag) {
        PlayerData data = getPlayerData(player.getUniqueId());
        if (data == null) {
            player.sendMessage(TextUtils.colorString("&c[!] Profil veriniz bulunamadı."));
            return false;
        }

        // Karakter uzunluğu kontrolü (Modelde belirttiğimiz gibi max 5 karakter)
        if (newTag.length() > 5 || newTag.isEmpty()) {
            player.sendMessage(TextUtils.colorString("&c[!] Etiketiniz en fazla 5 karakterden oluşabilir!"));
            return false;
        }

        // Küfür ve argo kontrolü (util/ProfanityFilter kullanılıyor)
        if (ProfanityFilter.containsProfanity(newTag)) {
            player.sendMessage(TextUtils.colorString("&c[!] Girdiğiniz etiket argo veya uygunsuz kelime içeriyor!"));
            return false;
        }

        // Her şey yolundaysa etiketi büyük harfe çevirerek kaydet
        String finalTag = newTag.toUpperCase();
        data.setTag(finalTag);
        
        player.sendMessage(TextUtils.colorString("&a[✓] Etiketiniz başarıyla &e#" + finalTag + " &aolarak güncellendi!"));
        return true;
    }

    /**
     * Tüm aktif oyuncu verilerini döner (İleride toplu işlemler için gerekecek).
     */
    public Map<UUID, PlayerData> getPlayerDataMap() {
        return playerDataMap;
    }
}
