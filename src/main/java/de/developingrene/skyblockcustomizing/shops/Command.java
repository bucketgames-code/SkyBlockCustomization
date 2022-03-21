package de.developingrene.skyblockcustomizing.shops;

import de.developingrene.skyblockcustomizing.SkyBlockCustomizing;
import de.developingrene.skyblockcustomizing.items.Builder;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.io.File;
import java.io.IOException;

public class Command implements CommandExecutor {
    private static File file = new File(SkyBlockCustomizing.getPlugin().getDataFolder().getPath(), "shops.yml");
    private static FileConfiguration conf = YamlConfiguration.loadConfiguration(file);
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (args.length==2){
            if (args[0].equalsIgnoreCase("spawn")){
                Villager vil = (Villager) p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
                vil.setAI(false);
                vil.setCustomName(ChatColor.translateAlternateColorCodes('&',args[1]));
                vil.setCustomNameVisible(true);
                vil.setSilent(true);
                vil.setVillagerType(Villager.Type.PLAINS);
                vil.setProfession(Villager.Profession.SHEPHERD);
                vil.setPersistent(true);
                vil.setRemoveWhenFarAway(false);
                MerchantRecipe merchantRecipe = (MerchantRecipe) new MerchantRecipe(new Builder().Build("item-coin"),0,999999999,false,0,0);
                ItemStack is = new Builder().Build("item-broken_coin");
                is.setAmount(9);
                merchantRecipe.addIngredient(is);
                vil.setRecipe(0,merchantRecipe);
                vil.setRecipe(1,merchantRecipe);
                vil.setCanPickupItems(false);
                vil.setGlowing(true);
                /*int id = 0;
                if (!conf.contains("id.0.vil")){
                    id = 0;
                } else {
                    id = Integer.valueOf(Integer.valueOf(conf.getConfigurationSection("id").getKeys(false).size()+1));
                }
                conf.set("id."+id+".vil",vil);
                try {
                    conf.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
        }
        return false;
    }
}
