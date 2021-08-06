package me.kodysimpson.particles;

import org.bukkit.plugin.java.JavaPlugin;

public final class Particles extends JavaPlugin {

    private static Particles plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getServer().getPluginManager().registerEvents(new MovementListener(), this);
        getCommand("spiral").setExecutor(new SpiralCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Particles getPlugin() {
        return plugin;
    }
}
