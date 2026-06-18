package com.kuramamc.valorant.model.weapon;

public enum WeaponType {
    SIDEARM("Tabanca"),
    SMG("Hafif Makineli"),
    SHOTGUN("Pompalı"),
    RIFLE("Taarruz Tüfeği"),
    SNIPER("Keskin Nişancı"),
    HEAVY("Ağır Makineli"),
    MELEE("Yakın Dövüş");

    private final String displayName;

    WeaponType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
