package com.kuramamc.valorant.command.impl;

import com.kuramamc.valorant.command.AbstractCommand;
import com.kuramamc.valorant.manager.GameManager;
import com.kuramamc.valorant.game.round.GameState;
import com.kuramamc.valorant.util.TextUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValorantAdminCommand extends AbstractCommand {

    public ValorantAdminCommand() {
        super("vadmin", "valorant.admin");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission(getPermission())) {
            sender.sendMessage(TextUtils.colorString("&c[!] Bu komutu kullanmak için yetkiniz yok!"));
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(TextUtils.colorString("&8[&c&lVALORANT ADMIN&8]"));
            sender.sendMessage(TextUtils.colorString("&e/vadmin baslat &7- Maçı zorla başlatır."));
            sender.sendMessage(TextUtils.colorString("&e/vadmin durdur &7- Maçı lobbide bekletir."));
            return true;
        }

        // Alt komut (Sub-command) mantığı
        if (args[0].equalsIgnoreCase("baslat")) {
            GameManager.getInstance().setGameState(GameState.STARTING);
            sender.sendMessage(TextUtils.colorString("&a[✓] Oyun durumu STARTING (Geri sayım) olarak değiştirildi."));
        } else if (args[0].equalsIgnoreCase("durdur")) {
            GameManager.getInstance().setGameState(GameState.WAITING);
            sender.sendMessage(TextUtils.colorString("&c[!] Oyun durumu WAITING (Bekleme) olarak değiştirildi."));
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("baslat", "durdur");
        }
        return new ArrayList<>();
    }
}
