package com.kuramamc.valorant.api.service;

import org.bukkit.entity.Player;

public interface EconomyService {

    /**
     * Oyuncunun mevcut kredi bakiyesini döner.
     */
    int getCredits(Player player);

    /**
     * Oyuncuya kredi ekler (Maksimum 9000 sınırını burada koruyabilirsin).
     */
    void addCredits(Player player, int amount);

    /**
     * Oyuncudan kredi eksiltir. Bakiye yetersizse false döner.
     */
    boolean removeCredits(Player player, int amount);

    /**
     * Oyuncunun kredisini doğrudan setler.
     */
    void setCredits(Player player, int amount);
}
