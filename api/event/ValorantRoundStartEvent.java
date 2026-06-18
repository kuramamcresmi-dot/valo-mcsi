package com.kuramamc.valorant.api.event;

import com.kuramamc.valorant.game.GameSession;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ValorantRoundStartEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final GameSession session;
    private final int roundNumber;

    public ValorantRoundStartEvent(GameSession session, int roundNumber) {
        this.session = session;
        this.roundNumber = roundNumber;
    }

    public GameSession getSession() {
        return session;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
