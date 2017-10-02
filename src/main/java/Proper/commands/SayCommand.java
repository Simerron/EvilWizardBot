package Proper.commands;

import Proper.Command;
import Proper.tools.Send_Message;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Created by Simerron on 06/07/2017.
 * Last edited by Simerron on 06/07/2017
 */
public class SayCommand implements Command {

    @Override
    public void Help(MessageReceivedEvent event) {
        Send_Message.send(event.getChannel(), "```Make the bot delete your message and say all the word behind the command```");
    }

    @Override
    public void Action(MessageReceivedEvent event, String[] args) {
        event.getMessage().delete();
        String Message = "";
        for (String Word : args){
            Message += Word +" ";
        }
        Send_Message.send(event.getChannel(), Message);
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {

    }

    @Override
    public void Testing(MessageReceivedEvent event, String[] args) {
        Action(event, args);
    }
}
