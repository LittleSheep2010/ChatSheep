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

        if( command.getName().equalsIgnoreCase("shout") ) {
            String shoutMessage = StringUtils.join(args, ' ', 0, args.length);

            if( shoutMessage == null ) { return false; }

            Bukkit.broadcastMessage("§6[SHOUT]§b(" + playerName  + ") -> §8§l" + shoutMessage);
            return true;
        }

        if( command.getName().equalsIgnoreCase("loudly") ) {
            String loudlyMessage = StringUtils.join(args, ' ', 0, args.length);

            if( loudlyMessage == null ) { return false; }
        }

        return false;
    }
}