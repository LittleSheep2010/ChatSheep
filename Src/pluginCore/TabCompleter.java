package pluginCore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TabCompleter implements TabExecutor {
    List<String> subCommands1 = new ArrayList<>();
    List<String> subCommands2 = new ArrayList<>();
    List<String> subCommands3 = new ArrayList<>();
    List<String> subCommands4 = new ArrayList<>();
    List<String> subCommands5 = new ArrayList<>();
    List<String> subCommands6 = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(strings.length > 0 ? strings[0] : "Null parameter");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {

        // subCommand level 1
        if(strings.length == 0) {
            if( command.getName().equalsIgnoreCase("shout") ) {
                subCommands1.add("Message");
            }

            return subCommands1;
        }

        if(strings.length > 1) return new ArrayList<>();

        return subCommands1.stream().filter(a -> s.startsWith(strings[0])).collect(Collectors.toList());
    }
}