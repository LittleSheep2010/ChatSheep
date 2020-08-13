package pluginCore;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;

public class EventProcessing implements Listener {

    // Attack event
    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {
        if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            String attackPlayerName = event.getDamager().getName();
            String beattackPlayerName = event.getEntity().getName();

            String msg = null;
            // BaseComponent afterMsg = null;

            // Send attack player message
            msg = "§6[ATTACK]§e(WARNING)§8§l You caused " +
                    event.getDamage() + " damage to the " + beattackPlayerName;
            // afterMsg.addExtra(msg);

            // event.getDamager().spigot().sendMessage(ChatMessageType.ACTION_BAR,
            //        TextComponent.fromLegacyText(msg));

            event.getDamager().sendMessage("§6[ATTACK]§e(WARNING)§8§l You caused " +
                    event.getDamage() + " damage to the " + beattackPlayerName);

            // Send be attack player message
            event.getEntity().sendMessage("§6[ATTACK]§e(WARNING)§8§l You suffered " + event.getDamage()
                    + " damage from the " + attackPlayerName);

        } else if(event.getEntity() instanceof Player && !(event.getDamager() instanceof Player) ) {
            String attackPlayerName = event.getDamager().getName();

            // Send be attack player message
            event.getEntity().sendMessage("§6[ATTACK]§e(WARNING)§8§l You suffered " + event.getDamage()
                    + " damage from the " + attackPlayerName);

        } else if(event.getDamager() instanceof Player && !(event.getEntity() instanceof Player) ) {
            String beattackPlayerName = event.getEntity().getName();

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
        event.getPlayer().sendMessage("§8§l=============================================");
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        event.setQuitMessage(null);

        // Send global message
        Bukkit.broadcastMessage("§6[PLAYER]§b(Join) " + event.getPlayer().getName() + " is leave server");
    }
}
