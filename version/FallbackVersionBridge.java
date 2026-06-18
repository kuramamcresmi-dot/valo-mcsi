package com.kuramamc.valorant.version;

import com.kuramamc.valorant.util.TextUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class FallbackVersionBridge implements VersionBridge {
    private final String version;

    public FallbackVersionBridge(String version) {
        this.version = version;
    }

    @Override
    public void sendActionBar(Player player, String message) {
        // Modern Spigot API'si doğrudan Actionbar destekler, NMS paketine girmeden çözeriz
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(TextUtils.colorString(message)));
    }

    @Override
    public void injectEntityPacket(Player player) {
        // Fallback modunda paket enjeksiyonu es geçilir veya standart takım api'si kullanılır
    }

    @Override
    public String getServerVersion() {
        return this.version;
    }
}
