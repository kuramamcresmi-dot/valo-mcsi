package com.kuramamc.valorant.game;

import com.kuramamc.valorant.game.arena.Arena;
import com.kuramamc.valorant.game.team.TeamManager;
import com.kuramamc.valorant.model.game.KuramaSpike;

public class GameSession {
    private final Arena arena;
    private final TeamManager teamManager;
    private KuramaSpike activeSpike;
    private int currentRound;

    public GameSession(Arena arena) {
        this.arena = arena;
        this.teamManager = new TeamManager();
        this.currentRound = 1;
        this.activeSpike = null;
    }

    // Harita verilerini çekmek için
    public Arena getArena() { 
        return arena; 
    }

    // Takımları ve skorları yönetmek için
    public TeamManager getTeamManager() { 
        return teamManager; 
    }
    
    // Kurulu olan Kurama/Spike objesini almak için
    public KuramaSpike getActiveSpike() { 
        return activeSpike; 
    }
    
    // Spike kurulduğunda veya çözüldüğünde durumunu güncellemek için
    public void setActiveSpike(KuramaSpike spike) { 
        this.activeSpike = spike; 
    }

    // Anlık turun kaçıncı tur olduğunu almak için
    public int getCurrentRound() { 
        return currentRound; 
    }
    
    // Tur bittiğinde yeni tura geçmek için (+1 ekler)
    public void incrementRound() { 
        this.currentRound++; 
    }
}
