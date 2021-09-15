package mc.gregvroberts.armorstandgui.events;

import mc.gregvroberts.armorstandgui.ArmorStandGUI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuHandler implements Listener {

    ArmorStandGUI plugin;

    public MenuHandler(ArmorStandGUI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked(); // get the player

        // Menu List
        final String MAIN_MENU = ChatColor.BLUE + "Armor Stand GUI";

        if (event.getView().getTitle().equalsIgnoreCase(MAIN_MENU)) {
            switch(event.getCurrentItem().getType()) {
                case ARMOR_STAND:
                    player.sendMessage("Opened armor stand create menu");
                    player.closeInventory();
                    // todo: Open the armor stand inventory
                    break;
                case BARRIER:
                    player.sendMessage("Closing main menu");
                    player.closeInventory();
                    break;
            }
        }
    }

}
