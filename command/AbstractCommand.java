package com.kuramamc.valorant.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import java.util.List;

public abstract class AbstractCommand implements CommandExecutor, TabCompleter {
    private final String name;
    private final String permission;

    public AbstractCommand(String name, String permission) {
        this.name = name;
        this.permission = permission;
    }

    public String getName() { return name; }
    public String getPermission() { return permission; }

    @Override
    public abstract boolean onCommand(CommandSender sender, Command command, String label, String[] args);

    @Override
    public abstract List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args);
}
