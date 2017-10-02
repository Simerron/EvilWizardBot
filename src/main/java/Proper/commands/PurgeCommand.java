package Proper.commands;

import Proper.Command;
import Proper.tools.Send_Message;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.Permissions;

import static sun.misc.Version.println;

/**
 * Created by Simerron on 06/07/2017.
 * Last edited by Simerron on 06/07/2017
 */
public class PurgeCommand implements Command {

    @Override
    public void Help(MessageReceivedEvent event) {
        Send_Message.send(event.getChannel(), "```This is a purge command and should be use only by admin or moderator \n\nEnter a number after the command to tell how many messages you want to deletes```");
        return;
    }

    @Override
    public void Action(MessageReceivedEvent event, String[] args) {
        int i =50;
        if (args.length !=0) {
            i = Integer.parseInt(args[0]);
        }
        event.getChannel().getMessageHistory(i).bulkDelete().clear();
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        event.getAuthor().getOrCreatePMChannel().sendMessage("**__Warning__** Using admin reserved command could be a reasons of **kick/ban/perma-ban**");
    }

    @Override
    public void Testing(MessageReceivedEvent event, String[] args) {
        if (event.getAuthor().getPermissionsForGuild(event.getGuild()).contains(Permissions.MANAGE_MESSAGES) && event.getAuthor().isBot() == false){
            Action(event, args);
        }else execute(event, args);
    }
}