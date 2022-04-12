package de.developingrene.skyblockcustomizing;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class Listeners implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        TextComponent c = new TextComponent("§aFor better expirence ");
        TextComponent download = new TextComponent("§6Download§a ");
        download.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/texturepack"));
        TextComponent c2 = new TextComponent("the texturepack.");
        c.addExtra(download);
        c.addExtra(c2);
        e.getPlayer().spigot().sendMessage(c);
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Location loc = e.getPlayer().getLocation();
        String wname = loc.getWorld().getName().toString();
        if (wname.contains(e.getPlayer().getUniqueId().toString())) {
            e.setCancelled(false);
        }else if (e.getPlayer().hasPermission("sbs.event.break.bypass")){
            e.setCancelled(false);
        }else{
            e.setCancelled(true);
        }
    }

}
