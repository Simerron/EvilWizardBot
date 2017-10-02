package Proper.tools;

import Proper.Command;
import Proper.commands.*;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.HashMap;

/**
 * Created by Simerron on 06/07/2017.
 * Last edited by Simerron on 06/07/2017
 */
public class Command_Handler {
    private HashMap<String, Command> cmd = new HashMap<String, Command>();

    public Command_Handler() {
        cmd.put("ping", new PingCommand());
        cmd.put("purge", new PurgeCommand());
        cmd.put("r", new RollCommand());
        cmd.put("help", new HelpCommand());
        cmd.put("say", new SayCommand());
        cmd.put("join", new JoinCommand());
        cmd.put("musicadd", new PlayerAddCommand());
        cmd.put("play", new PlayCommand());
    }

    public void handle (MessageReceivedEvent event, String[] args, String invoke){
        //System.out.println("Command is Handling");
        if (args.length != 0) {
            if (args[0].equalsIgnoreCase("-help") || args[0].equalsIgnoreCase("-h")) {
                cmd.get(invoke).Help(event);
                //System.out.println("Help case Handled");
            }else {
                cmd.get(invoke).Testing(event, args);
                //System.out.println("Command Handled");
            }
        } else {
            cmd.get(invoke).Testing(event, args);
            //System.out.println("Command Handled");
        }
    }
}
