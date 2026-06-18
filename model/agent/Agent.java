package com.kuramamc.valorant.model.agent;

import java.util.List;

public class Agent {
    private final String name;
    private final String description;
    private final List<String> abilities; // Yetenek isimleri

    public Agent(String name, String description, List<String> abilities) {
        this.name = name;
        this.description = description;
        this.abilities = abilities;
    }

    public String getName() { return name; }
    public List<String> getAbilities() { return abilities; }
}
