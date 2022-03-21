package de.developingrene.skyblockcustomizing.items;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (args.length == 1){
            if (args[0].equalsIgnoreCase("emerald_sword")){
                p.getInventory().addItem(new Builder().Build("item-emerald_sword"));
            }
            if (args[0].equalsIgnoreCase("coin")){
                p.getInventory().addItem(new Builder().Build("item-coin"));
            }
            if (args[0].equalsIgnoreCase("broken_coin")){
                p.getInventory().addItem(new Builder().Build("item-broken_coin"));
            }
            if (args[0].equalsIgnoreCase("5dollar")){
                p.getInventory().addItem(new Builder().Build("item-5dollar"));
            }
        }
        return false;
    }
}
