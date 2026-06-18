package com.kuramamc.valorant.game.team;

import com.kuramamc.valorant.model.game.TeamType;
import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TeamManager {
    private final Map<UUID, TeamType> playerTeams = new HashMap<>();
    private final Map<TeamType, Integer> teamScores = new HashMap<>();

    public TeamManager() {
        teamScores.put(TeamType.BLUE, 0);
        teamScores.put(TeamType.RED, 0);
    }

    public void setTeam(Player player, TeamType team) {
        playerTeams.put(player.getUniqueId(), team);
    }

    public TeamType getTeam(Player player) {
        return playerTeams.getOrDefault(player.getUniqueId(), TeamType.SPECTATOR);
    }

    public void addScore(TeamType team) {
        teamScores.put(team, teamScores.get(team) + 1);
    }

    public int getScore(TeamType team) {
        return teamScores.getOrDefault(team, 0);
    }

    public void clearTeams() {
        playerTeams.clear();
        teamScores.put(TeamType.BLUE, 0);
        teamScores.put(TeamType.RED, 0);
    }
}
