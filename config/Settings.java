package com.kuramamc.valorant.config;

import java.util.Arrays;
import java.util.List;

public class Settings {
    // Genel Oyun Ayarları
    private int roundTimeSeconds = 100;
    private int buyTimeSeconds = 30;
    private int spikeDetonationSeconds = 45;
    
    // Küfür Filtresi Listesi (Varsayılan)
    private List<String> profanityBlacklist = Arrays.asList("amk", "oc", "siktir", "fuck", "shit", "aq");

    // Getters & Setters
    public int getRoundTimeSeconds() { return roundTimeSeconds; }
    public void setRoundTimeSeconds(int roundTimeSeconds) { this.roundTimeSeconds = roundTimeSeconds; }

    public int getBuyTimeSeconds() { return buyTimeSeconds; }
    public void setBuyTimeSeconds(int buyTimeSeconds) { this.buyTimeSeconds = buyTimeSeconds; }

    public int getSpikeDetonationSeconds() { return spikeDetonationSeconds; }
    public void setSpikeDetonationSeconds(int spikeDetonationSeconds) { this.spikeDetonationSeconds = spikeDetonationSeconds; }

    public List<String> getProfanityBlacklist() { return profanityBlacklist; }
    public void setProfanityBlacklist(List<String> profanityBlacklist) { this.profanityBlacklist = profanityBlacklist; }
}
