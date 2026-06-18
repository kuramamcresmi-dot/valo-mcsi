package com.kuramamc.valorant.util;

import org.bukkit.Location;
import org.bukkit.util.BoundingBox;

public class RegionUtils {
    /**
     * Bir lokasyonun iki nokta arasındaki bölgede olup olmadığını kontrol eder.
     */
    public static boolean isInside(Location location, Location corner1, Location corner2) {
        BoundingBox box = BoundingBox.of(corner1, corner2);
        return box.contains(location.toVector());
    }
}
