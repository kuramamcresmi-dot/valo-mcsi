package com.kuramamc.valorant.api.event;

import com.kuramamc.valorant.model.game.KuramaSpike;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class KuramaSpikePlantEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player planter;
    private final KuramaSpike spike;

    public KuramaSpikePlantEvent(Player planter, KuramaSpike spike) {
        this.planter = planter;
        this.spike = spike;
    }

    public Player getPlanter() {
        return planter;
    }

    public KuramaSpike getSpike() {
        return spike;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
