package com.kuramamc.valorant.manager;

import com.kuramamc.valorant.game.round.GameState;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

public class GameManager {
    private static GameManager instance;
    private GameState currentState = GameState.WAITING;
    private final Map<UUID, Boolean> alivePlayers = new HashMap<>();

    public static GameManager getInstance() {
        if (instance == null) instance = new GameManager();
        return instance;
    }

    public void setGameState(GameState state) {
        this.currentState = state;
        // Burada state değiştiğinde yapılacak işlemleri (örn: bariyerleri aç) tetikleyeceğiz
    }

    public GameState getCurrentState() { return currentState; }
}
