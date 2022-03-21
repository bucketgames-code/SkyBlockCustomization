package de.developingrene.skyblockcustomizing.shops;


import de.developingrene.skyblockcustomizing.SkyBlockCustomizing;
import de.developingrene.skyblockcustomizing.items.Builder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.io.File;
import java.io.IOException;

public class Manager {

    private static File file = new File(SkyBlockCustomizing.getPlugin().getDataFolder().getPath(), "shops.yml");
    private static FileConfiguration conf = YamlConfiguration.loadConfiguration(file);

    protected void addShop(Location loc, String name){
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int id = 0;
        if (conf.getConfigurationSection("id").getKeys(false).equals(null)){
            id = 0;
        } else {
            Integer.valueOf(conf.getConfigurationSection("id").getKeys(false).size()+1);
        }
        conf.set("id."+id+".loc",loc);
        conf.set("id."+id+".name",name);
        try {
            conf.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        spawnNPC();
    }

    public void spawnNPC(){
        setTest();
        Bukkit.getServer().getWorlds().forEach(world -> {
            world.getEntities().forEach(entity -> {
                if (entity.getType().equals(EntityType.VILLAGER)){
                    Villager vil = (Villager) entity;
                    if(!vil.hasAI()){
                        vil.remove();
                    }
                }
            });
        });
        if (file.exists()){
            for (int id = 0; id < conf.getConfigurationSection("id").getKeys(false).size() ;id++){
                Location loc = conf.getLocation("id."+id+".loc");
                Villager vil = (Villager) loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);

                vil.setProfession(Villager.Profession.SHEPHERD);
                vil.setVillagerType(Villager.Type.JUNGLE);
                vil.setAI(false);
                vil.setCanPickupItems(false);
                vil.setCustomName(ChatColor.translateAlternateColorCodes('&',conf.getString("id."+id+".name")));
                vil.setCustomNameVisible(true);
                vil.setInvulnerable(true);
                vil.setSilent(true);
                vil.setPersistent(true);
                MerchantRecipe merchantRecipe = (MerchantRecipe) new MerchantRecipe(new Builder().Build("item-coin"),9999);
                ItemStack is = new Builder().Build("item-broken_coin");
                is.setAmount(9);
                merchantRecipe.addIngredient(is);
                vil.setRecipe(1,merchantRecipe);
            }
        }
    }

    private static void setTest(){
        Location loc = new Location(Bukkit.getWorld("world"),99999.0,99999.0,99999.0);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        conf.set("id.0.loc",loc);
        conf.set("id.0.name","§6TEST");
        try {
            conf.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
