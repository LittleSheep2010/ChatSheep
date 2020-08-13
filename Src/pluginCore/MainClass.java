package pluginCore;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin {

    @Override
    public void onDisable() {

    }

    @Override
    public void onLoad() {
        getLogger().info("[JavaSheep]:[PluginCore] Start ChatSheep...");
        getLogger().info("[JavaSheep]:[PluginCore] *** PluginCore -> ChatSheep ***");
    }

    @Override
    public void onEnable() {
        getLogger().info("[JavaSheep]:[PluginCore] Start ChatSheep...");
        getLogger().info("[JavaSheep]:[PluginCore] *** PluginCore -> ChatSheep ***");
        getLogger().info("[JavaSheep]:[ChatSheep] Version 1.0.2");
        getLogger().info("[JavaSheep]:[ChatSheep] Welcome using Sheep family made a new spigot Plugin!");
        getLogger().info("[JavaSheep]:[ChatSheep] ChatSheep is Enable");

        Bukkit.getPluginCommand("shout").setExecutor( new CommandCore() );
        Bukkit.getPluginCommand("shout").setTabCompleter( new TabCompleter() );

        // Bukkit.getPluginManager().registerEvent( new EntityDamageByEntityEvent(), new EventProcessing() );

        Bukkit.getPluginManager().registerEvents( new EventProcessing(), this );

        // getServer().dispatchCommand(getServer().getConsoleSender(), "scoreboard objectives add HealthBar health");
        // getServer().dispatchCommand(getServer().getConsoleSender(), "scoreboard objectives setdisplay list HealthBar");
    }
}

