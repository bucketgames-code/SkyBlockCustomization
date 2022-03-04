package de.developingrene.skyblockcustomizing;

import org.bukkit.plugin.java.JavaPlugin;

public final class SkyBlockCustomizing extends JavaPlugin {
    private static SkyBlockCustomizing plugin;

    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new Listeners(), this);
        httpServer.CC();
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
