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

public class Manager {

    private static File file;
    private static FileConfiguration conf;

    /*
    Request Types
    island-home for teleport or island creation
    island-settings for Island Settings
    island-coop for a add-coop
    island-uncoop for a uncoop
    island-invite for Island Invitation
    island-kick for temporary kicking from island
    island-ban for permanent ban from island
    island-lock for a locked island
    island-delete for delete a island
    island-tp for teleporting to a island
    DEV:
    island-dev-getPlayersIsland for get a island at players Position
    island-dev-getIslandOwner to get a Island from a Player
    */
    public void doAction(Player p, String request) {
        file = new File(SkyBlockCustomizing.getPlugin().getDataFolder() + "/players/", p.getUniqueId() + ".yml");
        conf = YamlConfiguration.loadConfiguration(file);
        if (request.equalsIgnoreCase("island-home")) {
            if (!isPlayerExists(p)) {
                p.sendMessage("§r[ SkyBlock §r] §eErstelle Insel...");
                createIsland(p);
                p.sendMessage("§r[ SkyBlock §r] §aTeleportiere...");
                p.teleport(getIslandSpawn(p));
                p.sendMessage("§r[ SkyBlock §r] §aDu wurdest zu deiner Insel Teleportiert.");
            } else {
                p.sendMessage("§r[ SkyBlock §r] §aTeleportiere...");
                p.teleport(getIslandSpawn(p));
                p.sendMessage("§r[ SkyBlock §r] §aDu wurdest zu deiner Insel Teleportiert.");
            }
        } else if (request.equalsIgnoreCase("island-settings")) {

        } else if (request.equalsIgnoreCase("island-coop")) {

        } else if (request.equalsIgnoreCase("island-uncoop")) {

        } else if (request.equalsIgnoreCase("island-invite")) {

        } else if (request.equalsIgnoreCase("island-kick")) {

        } else if (request.equalsIgnoreCase("island-ban")) {

        } else if (request.equalsIgnoreCase("island-lock")) {

        } else if (request.equalsIgnoreCase("island-delete")) {
            if (isPlayerExists(p)) {
                p.sendMessage("§r[ SkyBlock §r] §4Lösche Insel...");
                deleteIsland(p);
                p.sendMessage("§r[ SkyBlock §r] §aDeine Insel wurde gelöscht.");
            } else {
                p.sendMessage("§r[ SkyBlock §r] §cDu hast noch keine Insel.");
            }
        } else if (request.equalsIgnoreCase("island-tp")) {

        } else if (request.equalsIgnoreCase("island-dev-getIslandOwner")) {
            p.sendMessage("§r[ SkyBlock §r] §6" + getIslandOwner(p).getName());
        } else if (request.equalsIgnoreCase("island-dev-getPlayersIsland")) {

        }
    }



    private static Player getIslandOwner (Player p) {
        Location loc = p.getLocation();
        String isuuid = loc.getWorld().getName().toString().replace("is-","");
        return Bukkit.getPlayer(isuuid);
    }

    private static void createIsland (Player p){
        World template = Bukkit.getWorld("is-template");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv clone is-template is-" + p.getUniqueId());
        getConf().set("name", p.getName());
        getConf().set("position.world", "is-" + p.getUniqueId().toString());
        getConf().set("position.x", 8);
        getConf().set("position.y", 205);
        getConf().set("position.z", 8);
        // 8 205 8
        try {
            getConf().save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Location getIslandSpawn (Player p){
        return new Location(Bukkit.getWorld(getConf().getString("position.world")), getConf().getDouble("position.x"), getConf().getDouble("position.y"), getConf().getDouble("position.z"));
    }

    private static void deleteIsland (Player p){
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv delete is-" + p.getUniqueId());
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv confirm");
        file.delete();
    }

    private static boolean isPlayerExists (Player p){
        if (getFile().exists()) {
            return true;
        } else return false;
    }

    public static File getFile() {
        return file;
    }

    private static FileConfiguration getConf() {
        return conf;
    }
}
