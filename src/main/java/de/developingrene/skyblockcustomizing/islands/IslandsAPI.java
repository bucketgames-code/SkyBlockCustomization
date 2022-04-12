package de.developingrene.skyblockcustomizing.islands;

import de.developingrene.skyblockcustomizing.SkyBlockCustomizing;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class IslandsAPI {

    public static class PlayerIsland {

        public static void TeleportPlayerToIsland(Player target){
            if (PlayerHaveIsland(target)){
                target.teleport(getPlayersIsland(target));
            }else{
                target.sendMessage("§r[ SkyBlock §r] §eErstelle Insel...");
                CreatePlayersIsland(target);
                target.sendMessage("§r[ SkyBlock §r] §aTeleportiere...");
                target.teleport(getPlayersIsland(target));
                target.sendMessage("§r[ SkyBlock §r] §aDu wurdest zu deiner Insel Teleportiert.");
            }
        }

        public static Location getPlayersIsland(Player target){
            File file = new File(SkyBlockCustomizing.getPlugin().getDataFolder() + "/players/", target.getUniqueId() + ".yml");
            FileConfiguration conf = YamlConfiguration.loadConfiguration(file);
            if (conf.getString("position.world").equalsIgnoreCase("is-"+target.getUniqueId())){
                return new Location(Bukkit.getWorld(conf.getString("position.world")), conf.getDouble("position.x"), conf.getDouble("position.y"), conf.getDouble("position.z"));
            }
            return null;
        }

        public static void CreatePlayersIsland(Player p){
            File file = new File(SkyBlockCustomizing.getPlugin().getDataFolder() + "/players/", p.getUniqueId() + ".yml");
            FileConfiguration conf = YamlConfiguration.loadConfiguration(file);
            World template = Bukkit.getWorld("is-template");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv clone is-template is-" + p.getUniqueId());
            conf.set("name", p.getName());
            conf.set("position.world", "is-" + p.getUniqueId().toString());
            conf.set("position.x", 8);
            conf.set("position.y", 205);
            conf.set("position.z", 8);
            // 8 205 8
            try {
                conf.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void DeletePlayersIsland(Player target){
            File file = new File(SkyBlockCustomizing.getPlugin().getDataFolder() + "/players/", target.getUniqueId() + ".yml");
            FileConfiguration conf = YamlConfiguration.loadConfiguration(file);
            if (conf.getString("position.world").equalsIgnoreCase("is-"+target.getUniqueId())){
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv delete is-" + target.getUniqueId());
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv confirm");
                conf.set("position.world","null");
                try {
                    conf.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public static Boolean PlayerHaveIsland(Player target){
            File file = new File(SkyBlockCustomizing.getPlugin().getDataFolder() + "/players/", target.getUniqueId() + ".yml");
            FileConfiguration conf = YamlConfiguration.loadConfiguration(file);
            if (file.exists()){
                if (conf.getString("position.world").equalsIgnoreCase("is-"+target.getUniqueId())){
                    return true;
                }
            }
            return false;
        }

    }

}
