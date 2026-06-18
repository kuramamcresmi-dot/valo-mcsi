package com.kuramamc.valorant.game.arena;

import org.bukkit.Location;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private final String name;
    private Location attackerSpawn;
    private Location defenderSpawn;
    private final List<Location> aSiteCorners = new ArrayList<>();
    private final List<Location> bSiteCorners = new ArrayList<>();

    public Arena(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public Location getAttackerSpawn() { return attackerSpawn; }
    public void setAttackerSpawn(Location loc) { this.attackerSpawn = loc; }
    
    public Location getDefenderSpawn() { return defenderSpawn; }
    public void setDefenderSpawn(Location loc) { this.defenderSpawn = loc; }

    public List<Location> getASiteCorners() { return aSiteCorners; }
    public List<Location> getBSiteCorners() { return bSiteCorners; }
}
