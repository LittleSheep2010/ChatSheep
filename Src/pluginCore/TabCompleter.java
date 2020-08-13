package pluginCore;

import com.mysql.fabric.xmlrpc.base.Array;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TabCompleter implements TabExecutor {
    List<String> subCommands = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(strings.length > 0 ? strings[0] : "Null parameter");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if( command.getName().equalsIgnoreCase("shout") )
        { subCommands.add("Message"); }

        if(strings.length > 1) return new ArrayList<>();
         if(strings.length == 0) return subCommands;

        return subCommands.stream().filter(a -> s.startsWith(strings[0])).collect(Collectors.toList());
    }
}