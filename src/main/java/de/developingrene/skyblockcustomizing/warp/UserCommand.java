package de.developingrene.skyblockcustomizing.warp;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class UserCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        String arg = args[0];
        Player p = (Player) sender;
        if (arg.equalsIgnoreCase("set")){
            p.openInventory(mainSetUpInventory(p));
        }
        return false;
    }

    private static Inventory mainSetUpInventory(Player p){
        if (p.hasPermission("SBS.warps.setup")){
            Inventory inv = Bukkit.createInventory(null, 26);

            for (int i = 0; i < inv.getSize(); i++){
                if (inv.getItem(i) == null){
                    inv.setItem(i,ItemBuilder(Material.BLACK_STAINED_GLASS_PANE," ",new ArrayList<String>()));
                }
            }
            return inv;
        }
        return null;
    }

    private static ItemStack ItemBuilder(Material material, String name, ArrayList<String> lore){
        ItemStack is = new ItemStack(material);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }

}
