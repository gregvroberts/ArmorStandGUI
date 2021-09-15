package mc.gregvroberts.armorstandgui;

import mc.gregvroberts.armorstandgui.commands.ArmorStandCommand;
import mc.gregvroberts.armorstandgui.events.MenuHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class ArmorStandGUI extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("armorstand").setExecutor(new ArmorStandCommand(this));

        getServer().getPluginManager().registerEvents(new MenuHandler(this), this);
    }


    public void openMainMenu(Player player) {
        Inventory mainMenu = Bukkit.createInventory(player, 9, ChatColor.BLUE + "Armor Stand GUI");

        /*
         *  Options for main menu
         */

        // Create
        ItemStack create = new ItemStack(Material.ARMOR_STAND);
        ItemMeta createMeta = create.getItemMeta();
        createMeta.setDisplayName(ChatColor.GREEN + "Create");
        ArrayList<String> createLore = new ArrayList<>();
        createLore.add(ChatColor.DARK_PURPLE + "Create a new armor stand.");
        createMeta.setLore(createLore);
        create.setItemMeta(createMeta);

        // Close
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.RED + "Close");
        close.setItemMeta(closeMeta);

        mainMenu.setItem(0, create);
        mainMenu.setItem(8, close);

        player.openInventory(mainMenu);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
