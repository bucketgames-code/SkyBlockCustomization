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

public class mainMenu implements Listener {

    protected static Inventory PanelBuilder(){
        Inventory inv = Bukkit.createInventory(null,27,"Island Menu");
        ArrayList<String> GH = new ArrayList<String>();
        GH.add("Wenn du dies anklickst kommst du zu deiner Insel.");
        inv.setItem(10,ItemBuilder(Material.GRASS_BLOCK,"§aGo Home",GH));
        ArrayList<String> set = new ArrayList<String>();
        set.add("Wenn du hier klickst öffnen sich die Einstellungen der Insel.");
        inv.setItem(13,ItemBuilder(Material.REDSTONE_TORCH,"§dManage Island",set));
        inv.setItem(16,ItemBuilder(Material.BARRIER,"§cComming Soon",null));
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
            if (e.getWhoClicked().getOpenInventory().getTitle().equalsIgnoreCase("Island Menu")){
                e.setCancelled(true);
                if (e.getCurrentItem().getType().equals(Material.GRASS_BLOCK)){
                    p.closeInventory();
                    new Manager().doAction(p,"island-home");
                } else if (e.getCurrentItem().getType().equals(Material.REDSTONE_TORCH)){
                    p.closeInventory();
                    p.openInventory(managementMenu.getInv());
                } else if (e.getCurrentItem().getType().equals(Material.BARRIER)){

                } else if (e.getCurrentItem().getType().equals(null)){
                  e.setCancelled(false);
                } else {
                    e.getClickedInventory().setItem(e.getSlot(),colorPane(e.getCurrentItem().getType()));
                }
            }
        }
    }

    private static ItemStack colorPane(Material material){
        if (material.equals(Material.BLACK_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.RED_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else if (material.equals(Material.RED_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.BLUE_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else if (material.equals(Material.BLUE_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.BROWN_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else if (material.equals(Material.BROWN_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.CYAN_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else if (material.equals(Material.CYAN_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.GRAY_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else if (material.equals(Material.GRAY_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.GREEN_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else if (material.equals(Material.GREEN_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.LIGHT_BLUE_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else if (material.equals(Material.LIGHT_BLUE_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.LIGHT_GRAY_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else if (material.equals(Material.LIGHT_GRAY_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.LIME_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else if (material.equals(Material.LIME_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.MAGENTA_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else if (material.equals(Material.MAGENTA_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.ORANGE_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else if (material.equals(Material.ORANGE_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.PINK_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else if (material.equals(Material.PINK_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.PURPLE_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else if (material.equals(Material.PURPLE_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.WHITE_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else if (material.equals(Material.WHITE_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.YELLOW_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else if (material.equals(Material.YELLOW_STAINED_GLASS_PANE)){
            return ItemBuilder(Material.BLACK_STAINED_GLASS_PANE," ",new ArrayList<String>());
        } else return null;
    }

}
