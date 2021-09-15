package mc.gregvroberts.armorstandgui.commands;

import mc.gregvroberts.armorstandgui.ArmorStandGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;


import java.util.ArrayList;

public class ArmorStandCommand implements CommandExecutor {

    ArmorStandGUI plugin;

    public ArmorStandCommand(ArmorStandGUI plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender; // Cast sender to a player
            plugin.openMainMenu(player);
        }

        return true;
    }


}
