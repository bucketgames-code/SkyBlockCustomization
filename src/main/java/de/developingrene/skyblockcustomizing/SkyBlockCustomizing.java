package de.developingrene.skyblockcustomizing;

import de.developingrene.skyblockcustomizing.isMenu.mainMenu;
import de.developingrene.skyblockcustomizing.isMenu.Command;
import de.developingrene.skyblockcustomizing.isMenu.managementMenu;
import de.developingrene.skyblockcustomizing.shops.Manager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyBlockCustomizing extends JavaPlugin {
    private static SkyBlockCustomizing plugin;

    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        new Manager().spawnNPC();
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        getServer().getPluginManager().registerEvents(new mainMenu(), this);
        getServer().getPluginManager().registerEvents(new managementMenu(), this);
        httpServer.CC();
        getCommand("is").setExecutor(new Command());
        getCommand("item").setExecutor(new de.developingrene.skyblockcustomizing.items.Command());
        getCommand("shop").setExecutor(new de.developingrene.skyblockcustomizing.shops.Command());
        try {
            httpServer.start(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        httpServer.stop();
    }

    public static SkyBlockCustomizing getPlugin() {
        return plugin;
    }
}
