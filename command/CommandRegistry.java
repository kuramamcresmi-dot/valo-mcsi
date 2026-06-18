package com.kuramamc.valorant.command;

import com.kuramamc.valorant.command.impl.ValorantAdminCommand;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;

public class CommandRegistry {
    private final JavaPlugin plugin;
    private final List<AbstractCommand> commands = new ArrayList<>();

    public CommandRegistry(JavaPlugin plugin) {
        this.plugin = plugin;
        initCommands();
    }

    /**
     * Yeni yazdığın tüm komutları buraya eklemen yeterli.
     */
    private void initCommands() {
        commands.add(new ValorantAdminCommand());
        // İleride /market veya /ajan gibi komutlar yazarsan altına ekleyeceksin:
        // commands.add(new MarketCommand());
    }

    /**
     * Komutları sunucuya entegre eder (onEnable içinde çağrılacak).
     */
    public void registerAll() {
        for (AbstractCommand cmd : commands) {
            PluginCommand pluginCmd = plugin.getCommand(cmd.getName());
            if (pluginCmd != null) {
                pluginCmd.setExecutor(cmd);
                pluginCmd.setTabCompleter(cmd);
            } else {
                plugin.getLogger().warning("Komut bulunamadı, plugin.yml içerisine eklediniz mi?: " + cmd.getName());
            }
        }
    }
}
