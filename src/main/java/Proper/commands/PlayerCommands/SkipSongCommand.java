package Proper.commands.PlayerCommands;

import Proper.Command;
import Proper.tools.lavaplayer.SongManager;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.Permissions;

public class SkipSongCommand implements Command {
    @Override
    public void Help(MessageReceivedEvent event) {

    }

    @Override
    public void Action(MessageReceivedEvent event, String[] args) {
        SongManager.skipTrack(event.getChannel());
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {

    }

    @Override
    public void Testing(MessageReceivedEvent event, String[] args) {
        if (event.getAuthor().getPermissionsForGuild(event.getGuild()).contains(Permissions.MANAGE_CHANNELS)) Action(event,args);

    }
}
