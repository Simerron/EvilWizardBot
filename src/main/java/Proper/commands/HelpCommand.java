package Proper.commands;

import Proper.Command;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.Permissions;

/**
 * Created by Simerron on 06/07/2017.
 * Last edited by Simerron on 06/07/2017
 */
public class HelpCommand implements Command {

    @Override
    public void Help(MessageReceivedEvent event) {

    }

    @Override
    public void Action(MessageReceivedEvent event, String[] args) {
        event.getAuthor().getOrCreatePMChannel().sendMessage("```Here is some function of Evil Wizard bot :\n\n" +
                ".help      Send this page\n" +
                ".ping      Pong!\n" +
                ".purge     Bulk-delete messages in current channel\n" +
                ".r         Roll some dices\n" +
                ".say       Makes the Wizard talkative" +
                "\nMore Comming Soon...```");
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {
        event.getAuthor().getOrCreatePMChannel().sendMessage("```Here is some function of Evil Wizard bot :\n\n" +
                ".help      Send this page\n" +
                ".ping      Pong!\n" +
                ".r         Roll some dices\n" +
                ".say       Makes the Wizard talkative\n" +
                "\nMore Comming Soon...```");
    }

    @Override
    public void Testing(MessageReceivedEvent event, String[] args) {
        if (event.getAuthor().getPermissionsForGuild(event.getGuild()).contains(Permissions.MANAGE_MESSAGES))
            Action(event, args);
        else execute(event, args);
    }
}
