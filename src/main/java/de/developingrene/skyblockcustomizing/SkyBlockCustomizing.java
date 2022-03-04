package de.developingrene.skyblockcustomizing;

import org.bukkit.plugin.java.JavaPlugin;

public final class SkyBlockCustomizing extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        try {
            httpServer.start(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
