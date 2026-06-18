package com.kuramamc.valorant;

import com.kuramamc.valorant.command.CommandRegistry;
import com.kuramamc.valorant.config.ConfigLoader;
import com.kuramamc.valorant.listener.game.PlayerDeathListener;
import com.kuramamc.valorant.listener.game.PlayerJoinListener;
import com.kuramamc.valorant.listener.game.PlayerQuitListener;
import com.kuramamc.valorant.listener.network.PacketBlockPlacementBlocker;
import com.kuramamc.valorant.listener.network.PacketHitRegistrationListener;
import com.kuramamc.valorant.listener.network.ProtocolPacketListener;
import com.kuramamc.valorant.version.VersionBridge;
import com.kuramamc.valorant.version.VersionFactory;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ValorantPlugin extends JavaPlugin {

    private static ValorantPlugin instance;
    private ConfigLoader configLoader;
    private VersionBridge versionBridge;

    @Override
    public void onEnable() {
        instance = this;

        // 1. Sürüm Katmanını Yükle (NMS Bridge)
        this.versionBridge = VersionFactory.createBridge();
        getLogger().info("[✓] Sürüm uyumluluk katmanı aktif edildi: " + versionBridge.getServerVersion());

        // 2. Konfigürasyon Dosyalarını Yükle
        this.configLoader = new ConfigLoader(this);
        this.configLoader.load();
        getLogger().info("[✓] Konfigürasyon dosyaları başarıyla yüklendi.");

        // 3. Oyun İçi Listeners (Olay Dinleyicileri) Kaydı
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);

        // 4. ProtocolLib Network Paket Dinleyicileri Kaydı
        if (getServer().getPluginManager().getPlugin("ProtocolLib") != null) {
            ProtocolPacketListener.registerPackets(this);
            PacketHitRegistrationListener.register(this);
            PacketBlockPlacementBlocker.register(this);
            getLogger().info("[✓] ProtocolLib paket dinleyicileri başarıyla enjekte edildi.");
        } else {
            getLogger().severe("[X] ProtocolLib bulunamadı! Silah ve paket mekanikleri çalışmayacaktır!");
        }

        // 5. Komut Kayıt Sistemi
        CommandRegistry commandRegistry = new CommandRegistry(this);
        commandRegistry.registerAll();
        getLogger().info("[✓] Tüm Valorant komutları sisteme kaydedildi.");

        getLogger().info("===============================================");
        getLogger().info("   KuramaMC Valorant Core Başarıyla Aktif!     ");
        getLogger().info("===============================================");
    }

    @Override
    public void onDisable() {
        getLogger().info("===============================================");
        getLogger().info("   KuramaMC Valorant Core Kapatılıyor...       ");
        getLogger().info("===============================================");
        instance = null;
    }

    public static ValorantPlugin getInstance() {
        return instance;
    }

    public ConfigLoader getConfigLoader() {
        return configLoader;
    }

    public VersionBridge getVersionBridge() {
        return versionBridge;
    }
}
