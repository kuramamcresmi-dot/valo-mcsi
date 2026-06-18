package com.kuramamc.valorant.model.agent;

import java.util.UUID;

public class PlayerData {
    private final UUID uuid;
    private String tag; 
    private Agent selectedAgent;

    public PlayerData(UUID uuid) {
        this.uuid = uuid;
        this.tag = "NONE";
    }

    public void setTag(String tag) {
        if (tag.length() <= 5) {
            this.tag = tag;
        }
    }

    public void setSelectedAgent(Agent agent) {
        this.selectedAgent = agent;
    }
}
