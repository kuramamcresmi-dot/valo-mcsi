package com.kuramamc.valorant.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigLoader {
    private final JavaPlugin plugin;
    private final Settings settings;

    public ConfigLoader(JavaPlugin plugin) {
        this.plugin = plugin;
        this.settings = new Settings();
    }

    /**
     * Konfigürasyon dosyasını yükler veya yoksa varsayılanı oluşturur.
     */
    public void load() {
        // config.yml yoksa jar içerisinden kopyalar
        plugin.saveDefaultConfig();
        // Dosyayı diske göre yeniler
        plugin.reloadConfig();

        FileConfiguration config = plugin.getConfig();

        // Verileri config.yml'den çekip Settings nesnesine aktarıyoruz
        if (config.contains("game.round-time")) {
            settings.setRoundTimeSeconds(config.getInt("game.round-time"));
        } else {
            config.set("game.round-time", settings.getRoundTimeSeconds());
        }

        if (config.contains("game.buy-time")) {
            settings.setBuyTimeSeconds(config.getInt("game.buy-time"));
        } else {
            config.set("game.buy-time", settings.getBuyTimeSeconds());
        }

        if (config.contains("game.spike-time")) {
            settings.setSpikeDetonationSeconds(config.getInt("game.spike-time"));
        } else {
            config.set("game.spike-time", settings.getSpikeDetonationSeconds());
        }

        if (config.contains("profanity-blacklist")) {
            settings.setProfanityBlacklist(config.getStringList("profanity-blacklist"));
        } else {
            config.set("profanity-blacklist", settings.getProfanityBlacklist());
        }

        // Eğer yeni anahtarlar eklendiyse dosyayı kaydet
        plugin.saveConfig();
    }

    public Settings getSettings() {
        return settings;
    }
}
