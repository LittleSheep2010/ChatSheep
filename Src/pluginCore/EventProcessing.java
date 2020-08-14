package pluginCore;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;
import sun.applet.Main;

import java.awt.*;
import java.util.List;

import static org.bukkit.plugin.java.JavaPlugin.getPlugin;

public class EventProcessing implements Listener {
    // Attack event
    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {

        String beattackPlayerName = event.getEntity().getName();
        String attackPlayerName = event.getDamager().getName();

        if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {

            // Send attack player message
            event.getDamager().sendMessage("§6[ATTACK]§e(WARNING)§8§l You caused " +
                    event.getDamage() + " damage to the " + beattackPlayerName);

            // Send be attack player message
            event.getEntity().sendMessage("§6[ATTACK]§e(WARNING)§8§l You suffered " + event.getDamage()
                    + " damage from the " + attackPlayerName);

        } else if(event.getEntity() instanceof Player && !(event.getDamager() instanceof Player) ) {

            // Send be attack player message
            event.getEntity().sendMessage("§6[ATTACK]§e(WARNING)§8§l You suffered " + event.getDamage()
                    + " damage from the " + attackPlayerName);

        } else if(event.getDamager() instanceof Player && !(event.getEntity() instanceof Player) ) {

            // Send attack player message
            event.getDamager().sendMessage("§6[ATTACK]§e(WARNING)§8§l You caused " +
                    event.getDamage() + " damage to the " + beattackPlayerName);

        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);

        // Send global message
        Bukkit.broadcastMessage("§6[PLAYER]§b(Join) " + event.getPlayer().getName() + " is join server");

        // Send player message | The following content can be customized
        event.getPlayer().sendMessage("§8§l=============================================");
        event.getPlayer().sendMessage("   §7§l§kBAKA §c§lWELCOME TO SHEEP-SERVER §7§l§kBAKA");
        event.getPlayer().sendMessage("§7§l---------------------------------------------");
        event.getPlayer().sendMessage("   §ePlayer name -> §6" + event.getPlayer().getName());
        event.getPlayer().sendMessage("   §ePlayer level -> §6" + event.getPlayer().getLevel());
        event.getPlayer().sendMessage("   §ePlayer max HP -> §6" + event.getPlayer().getMaxHealth());
        event.getPlayer().sendMessage("§8§l=============================================");
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        event.setQuitMessage(null);

        // Send global message
        Bukkit.broadcastMessage("§6[PLAYER]§b(Leave) " + event.getPlayer().getName() + " is leave server");
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String playerMessage = event.getMessage();
        if(event.getPlayer().isOp()) {
            Bukkit.broadcastMessage("§6[SAY]§b(" + event.getPlayer().getName()  + " | Lv."
                    + event.getPlayer().getLevel() + " | Admin) -> §8§l" + playerMessage);
        } else {
            Bukkit.broadcastMessage("§6[SAY]§b(" + event.getPlayer().getName()  + " | Lv."
                    + event.getPlayer().getLevel() + ") -> §8§l" + playerMessage);
        }

        event.setCancelled(true);
    }

    @EventHandler
    public void onFoodClear(FoodLevelChangeEvent event) {
        int playerFoodLevel = event.getFoodLevel();
        if(playerFoodLevel == 0) {
            event.getEntity().setMaxHealth(1.0);
        } else if(playerFoodLevel != 0) {
            event.getEntity().resetMaxHealth();
        }
    }
}
