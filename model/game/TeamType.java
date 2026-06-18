package com.kuramamc.valorant.model.game;

import org.bukkit.ChatColor;

public enum TeamType {
    BLUE("Saldıranlar", ChatColor.BLUE), // Valorant'ta Mavi/Saldıran
    RED("Savunanlar", ChatColor.RED),    // Valorant'ta Kırmızı/Savunan
    SPECTATOR("İzleyiciler", ChatColor.GRAY);

    private final String displayName;
    private final ChatColor chatColor;

    TeamType(String displayName, ChatColor chatColor) {
        this.displayName = displayName;
        this.chatColor = chatColor;
    }

    public String getDisplayName() { return displayName; }
    public ChatColor getChatColor() { return chatColor; }
}
