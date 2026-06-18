package com.kuramamc.valorant.version;

import org.bukkit.Bukkit;

public class VersionFactory {

    /**
     * Sunucu sürümüne uygun olan köprüyü dinamik olarak döndürür.
     */
    public static VersionBridge createBridge() {
        String packageName = Bukkit.getServer().getClass().getPackage().getName();
        // Örn: org.bukkit.craftbukkit.v1_20_R3 -> v1_20_R3 kısmını ayıklar
        String version = packageName.substring(packageName.lastIndexOf('.') + 1);

        switch (version) {
            case "v1_20_R3":
                // return new Wrapper_1_20_R3(); // Sürümünüze özel NMS sınıfı
            case "v1_21_R1":
                // return new Wrapper_1_21_R1();
            default:
                // Modern Paper/Purpur sürümlerinde paket ismi değiştiği için fall-back (varsayılan) desteği
                return new FallbackVersionBridge(version);
        }
    }
}
