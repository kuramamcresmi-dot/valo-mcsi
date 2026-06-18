package com.kuramamc.valorant.util;

import org.bukkit.Location;
import org.bukkit.FluidCollisionMode;
import org.bukkit.util.RayTraceResult;
import org.bukkit.entity.Entity;

public class MathUtils {

    // Oyuncunun baktığı yöne doğru RayTrace atar
    public static RayTraceResult rayTrace(Location start, double distance) {
        return start.getWorld().rayTrace(
            start, 
            start.getDirection(), 
            distance, 
            FluidCollisionMode.NEVER, 
            true, 
            0.2, 
            e -> true // Buraya filtre eklenebilir (örn: ateş edeni görmezden gel)
        );
    }
}
