package Proper.commands;

import Proper.Command;
import Proper.tools.Send_Message;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Created by Simerron on 06/07/2017.
 * Last edited by Simerron on 06/07/2017
 */
public class PingCommand implements Command {
    @Override
    public void Help(MessageReceivedEvent event) {
        Send_Message.send(event.getChannel(), "```This is a ping command \nPing me and I Pong You```");
        return;
    }

    @Override
    public void Action(MessageReceivedEvent event, String[] args) {
        Send_Message.send(event.getChannel(), "Pong !");
        return;
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        return;
    }

    @Override
    public void Testing(MessageReceivedEvent event, String[] args){
        Action(event, args);
        return;
    }
}
