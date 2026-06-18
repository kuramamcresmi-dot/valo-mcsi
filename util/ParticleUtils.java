package com.kuramamc.valorant.util;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class ParticleUtils {
    public static void playEffect(Location loc, Particle particle, int count) {
        loc.getWorld().spawnParticle(particle, loc, count, 0.1, 0.1, 0.1, 0.05);
    }
    
    // Mermi izi (Trail) efekti için temel
    public static void drawLine(Location start, Location end, Particle particle) {
        // İleride aradaki mesafeye göre particle spawnlayacağız
    }
}
