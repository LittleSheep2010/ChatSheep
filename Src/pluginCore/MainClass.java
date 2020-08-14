package pluginCore;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.util.List;

public class MainClass extends JavaPlugin {

    public static FileConfiguration configurations;

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
        Bukkit.getPluginManager().registerEvents( new EventProcessing(), this );
        saveDefaultConfig();
    }

    public static void sendConsoleInfo(String info) {
        Bukkit.getLogger().info(info);
    }
}