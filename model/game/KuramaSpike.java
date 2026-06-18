package com.kuramamc.valorant.model.game;

import org.bukkit.Location;

public class KuramaSpike {
    private Location plantedLocation;
    private long plantTimeMillis;
    private SpikeState state;
    private final String site; // A_SITE, B_SITE, C_SITE

    public KuramaSpike(Location plantedLocation, String site) {
        this.plantedLocation = plantedLocation;
        this.site = site;
        this.plantTimeMillis = System.currentTimeMillis();
        this.state = SpikeState.PLANTED;
    }

    public Location getPlantedLocation() { return plantedLocation; }
    public long getPlantTimeMillis() { return plantTimeMillis; }
    public String getSite() { return site; }
    public SpikeState getState() { return state; }
    
    public void setState(SpikeState state) { 
        this.state = state; 
    }

    // Kurama'nın geçirebileceği durumlar
    public enum SpikeState {
        IDLE,       // Yerde duruyor veya birinin elinde
        PLANTED,    // Kuruldu, geri sayım işliyor
        DEFUSED,    // Çözüldü
        EXPLODED    // Patladı
    }
}
