package de.developingrene.skyblockcustomizing;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TexturepackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        p.sendMessage("§aDownloading Texturepack...");
//        p.setResourcePack("http://destiny-world.eu/dwd/SkyBlock.zip");
        p.setResourcePack("http://192.168.178.77/SkyBlock.zip");
        p.sendMessage("§aTexturepack activated");
        return false;
    }
}
