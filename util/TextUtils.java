package com.kuramamc.valorant.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.ChatColor;

public class TextUtils {

    // Renkli metinleri Component'e çevirir (1.20.3 için en iyisi)
    public static Component color(String text) {
        return LegacyComponentSerializer.legacyAmpersand().deserialize(text);
    }

    // Eski tip renkli String döner (GUI başlıkları vb. için)
    public static String colorString(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
