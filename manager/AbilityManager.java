package com.kuramamc.valorant.manager;

import com.kuramamc.valorant.model.agent.Agent;
import com.kuramamc.valorant.model.agent.AgentAbility;
import com.kuramamc.valorant.model.agent.PlayerData;
import com.kuramamc.valorant.util.CooldownUtils;
import com.kuramamc.valorant.util.TextUtils;
import org.bukkit.entity.Player;
import java.util.UUID;

public class AbilityManager {
    private static AbilityManager instance;

    private AbilityManager() {}

    public static AbilityManager getInstance() {
        if (instance == null) {
            instance = new AbilityManager();
        }
        return instance;
    }

    /**
     * Oyuncunun tuş kombinasyonuna (Q, E, C, X) göre yeteneği tetikler.
     */
    public void castAbility(Player player, String keybind) {
        UUID uuid = player.getUniqueId();
        
        // Oyuncunun profil verisini çekiyoruz
        PlayerData playerData = PlayerManager.getInstance().getPlayerData(uuid);
        if (playerData == null || playerData.getSelectedAgent() == null) {
            player.sendMessage(TextUtils.colorString("&c[!] Bir ajana sahip olmadığınız için yetenek kullanamazsınız!"));
            return;
        }

        Agent agent = playerData.getSelectedAgent();
        AgentAbility targetAbility = null;

        // Ajanın yetenek listesinden basılan tuşa ait olanı buluyoruz
        for (AgentAbility ability : agent.getAbilities()) {
            if (ability.getKeybind().equalsIgnoreCase(keybind)) {
                targetAbility = ability;
                break;
            }
        }

        if (targetAbility == null) return;

        // Cooldown Kontrolü
        if (CooldownUtils.hasCooldown(uuid, targetAbility.getName())) {
            long remaining = CooldownUtils.getRemainingSeconds(uuid, targetAbility.getName());
            player.sendMessage(TextUtils.colorString("&c[!] " + targetAbility.getName() + " hala bekleme süresinde! (&e" + remaining + "s&c)"));
            return;
        }

        // Yeteneği Çalıştır
        executeLogic(player, agent.getName(), targetAbility);

        // Cooldown Başlat
        CooldownUtils.setCooldown(uuid, targetAbility.getName(), targetAbility.getCooldownSeconds());
    }

    /**
     * Ajanların yetenek mekaniklerinin işlendiği mutfak.
     */
    private void executeLogic(Player player, String agentName, AgentAbility ability) {
        // Genel yetenek kullanım mesajı
        player.sendMessage(TextUtils.colorString("&a[⚡] &f" + ability.getName() + " &aaktif edildi!"));

        // Ajan bazlı özel mekaniklerin ayrımı
        switch (agentName.toUpperCase()) {
            case "JETT":
                if (ability.getKeybind().equalsIgnoreCase("E")) {
                    // Örnek Jett Dash: Oyuncuyu baktığı yöne doğru hızla fırlatır
                    player.setVelocity(player.getLocation().getDirection().multiply(1.6).setY(0.2));
                }
                break;
                
            case "PHOENIX":
                if (ability.getKeybind().equalsIgnoreCase("C")) {
                    // Phoenix duvarı veya alev havuzu tetikleme mantığı
                }
                break;

            case "SAGE":
                // Sage bariyer/iyileştirme mantığı
                break;

            default:
                break;
        }
    }
}
