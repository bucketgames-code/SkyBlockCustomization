package de.developingrene.skyblockcustomizing.isMenu;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        Player p = (Player) sender;
        p.openInventory(mainMenu.PanelBuilder());
        return false;
    }
}
