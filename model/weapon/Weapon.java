package com.kuramamc.valorant.model.weapon;

public class Weapon {
    private final String name;
    private final double damage;
    private final double range;
    private final double fireRate; // Saniye başına mermi
    private final int magazineSize;

    public Weapon(String name, double damage, double range, double fireRate, int magazineSize) {
        this.name = name;
        this.damage = damage;
        this.range = range;
        this.fireRate = fireRate;
        this.magazineSize = magazineSize;
    }

    // Getter metodları buraya gelecek
    public double getDamage() { return damage; }
    public double getRange() { return range; }
}
