package pluginCore;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.StringUtil;

import java.util.List;

public class CommandCore implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String playerName = sender.getName();
        Player senderPlayer = (Player) sender;

        if( command.getName().equalsIgnoreCase("shout") ) {
            String shoutMessage = StringUtils.join(args, ' ', 0, args.length);

            if( shoutMessage == null ) { return false; }

            String titleMsg = "§8§l" + shoutMessage;
            String titleName = null;
            if(senderPlayer.isOp() == true) {
                titleName = "§b" + playerName + " | Lv." +  senderPlayer.getLevel() + " | Admin";
                Bukkit.broadcastMessage("§6[SHOUT]§b(" + playerName  + " | Lv." + senderPlayer.getLevel()
                        + " | Admin) -> §8§l" + shoutMessage);
            } else {
                titleName = "§b" + playerName + " | Lv." +  senderPlayer.getLevel();
                Bukkit.broadcastMessage("§6[SHOUT]§b(" + playerName  + " | Lv." + senderPlayer.getLevel()
                        + ") -> §8§l" + shoutMessage);
            }


            for( Player onlinePlayers : Bukkit.getOnlinePlayers() ) {
                onlinePlayers.sendTitle(null, titleMsg);
            }

            return true;
        }

        return false;
    }
}