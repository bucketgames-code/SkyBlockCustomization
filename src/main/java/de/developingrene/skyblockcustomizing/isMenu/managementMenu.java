package de.developingrene.skyblockcustomizing.isMenu;

import de.developingrene.skyblockcustomizing.islands.Manager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class managementMenu implements Listener {

    protected static Inventory getInv(){
        Inventory inv = Bukkit.createInventory(null,54,"Island Settings");
//49
        inv.setItem(49,ItemBuilder(Material.CAULDRON,"§4§lDelete Island",null));
        for (int i = 0; i < inv.getSize(); i++){
            if (inv.getItem(i) == null){
                inv.setItem(i,ItemBuilder(Material.BLACK_STAINED_GLASS_PANE," ",new ArrayList<String>()));
            }
        }
        return inv;
    }

    private static ItemStack ItemBuilder(Material material, String name, ArrayList<String> lore){
        ItemStack is = new ItemStack(material);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory() != null){
            if (e.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase("Island Settings")){
                e.setCancelled(true);
                if (e.getCurrentItem().getType().equals(Material.CAULDRON)){
                    new Manager().doAction(p,"island-delete");
                } else if (e.getCurrentItem().getType().equals(null)){
                    e.setCancelled(false);
                } else {
                    e.getClickedInventory().setItem(e.getSlot(),colorPane(e.getCurrentItem().getType()));
                }
            }
        }
    }

    private static ItemStack colorPane(Material material){
        switch (material){
            case BLACK_STAINED_GLASS_PANE:
                return ItemBuilder(Material.RED_STAINED_GLASS_PANE," ",new ArrayList<String>());
            case RED_STAINED_GLASS_PANE:
                return ItemBuilder(Material.BLUE_STAINED_GLASS_PANE," ",new ArrayList<String>());
            case BLUE_STAINED_GLASS_PANE:
                return ItemBuilder(Material.BROWN_STAINED_GLASS_PANE," ",new ArrayList<String>());
            case BROWN_STAINED_GLASS_PANE:
                return ItemBuilder(Material.CYAN_STAINED_GLASS_PANE," ",new ArrayList<String>());
            case CYAN_STAINED_GLASS_PANE:
                return ItemBuilder(Material.GRAY_STAINED_GLASS_PANE," ",new ArrayList<String>());
            case GRAY_STAINED_GLASS_PANE:
                return ItemBuilder(Material.GREEN_STAINED_GLASS_PANE," ",new ArrayList<String>());
            case GREEN_STAINED_GLASS_PANE:
                return ItemBuilder(Material.LIGHT_BLUE_STAINED_GLASS_PANE," ",new ArrayList<String>());
            case LIGHT_BLUE_STAINED_GLASS_PANE:
                return ItemBuilder(Material.LIGHT_GRAY_STAINED_GLASS_PANE," ",new ArrayList<String>());
            case LIGHT_GRAY_STAINED_GLASS_PANE:
                return ItemBuilder(Material.LIME_STAINED_GLASS_PANE," ",new ArrayList<String>());
            case LIME_STAINED_GLASS_PANE:
                return ItemBuilder(Material.MAGENTA_STAINED_GLASS_PANE," ",new ArrayList<String>());
            case MAGENTA_STAINED_GLASS_PANE:
                return ItemBuilder(Material.ORANGE_STAINED_GLASS_PANE," ",new ArrayList<String>());
            case ORANGE_STAINED_GLASS_PANE:
                return ItemBuilder(Material.PINK_STAINED_GLASS_PANE," ",new ArrayList<String>());
            case PINK_STAINED_GLASS_PANE:
                return ItemBuilder(Material.PURPLE_STAINED_GLASS_PANE," ",new ArrayList<String>());
            case PURPLE_STAINED_GLASS_PANE:
                return ItemBuilder(Material.WHITE_STAINED_GLASS_PANE," ",new ArrayList<String>());
            case WHITE_STAINED_GLASS_PANE:
                return ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE," ",new ArrayList<String>());
            case YELLOW_STAINED_GLASS_PANE:
                return ItemBuilder(Material.BLACK_STAINED_GLASS_PANE," ",new ArrayList<String>());
        }
        return null;
    }

}
