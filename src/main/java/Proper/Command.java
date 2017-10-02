package Proper;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Created by Simerron on 06/07/2017.
 * Last edited by Simerron on 06/07/2017
 */
public interface Command {
    public void Help(MessageReceivedEvent event);
    public void Action(MessageReceivedEvent event, String[] args);
    public void execute(MessageReceivedEvent event, String[] args);
    public void Testing(MessageReceivedEvent event, String[] args);
}
