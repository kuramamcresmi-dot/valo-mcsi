package com.kuramamc.valorant.model.agent;

public class AgentAbility {
    private final String name;
    private final String description;
    private final int cooldownSeconds;
    private final String keybind; // Q, E, C veya X (Ulti)

    public AgentAbility(String name, String description, int cooldownSeconds, String keybind) {
        this.name = name;
        this.description = description;
        this.cooldownSeconds = cooldownSeconds;
        this.keybind = keybind;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getCooldownSeconds() { return cooldownSeconds; }
    public String getKeybind() { return keybind; }
}
