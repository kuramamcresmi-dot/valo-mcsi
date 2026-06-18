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

    public Arena getArena() { return arena; }
    public TeamManager getTeamManager() { return teamManager; }
    
    public KuramaSpike getActiveSpike() { return activeSpike; }
    public void setActiveSpike(KuramaSpike spike) { this.activeSpike = spike; }

    public int getCurrentRound() { return currentRound; }
    public void incrementRound() { this.currentRound++; }
}
