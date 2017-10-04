package Proper.commands.PlayerCommands;

import Proper.Command;
import Proper.tools.Command_Handler;
import Proper.tools.lavaplayer.SongManager;
import Proper.tools.lavaplayer.TrackScheduler;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IVoiceChannel;
import sx.blah.discord.handle.obj.Permissions;

public class LeaveCommand implements Command {
    @Override
    public void Help(MessageReceivedEvent event) {

    }

    @Override
    public void Action(MessageReceivedEvent event, String[] args) {
        IVoiceChannel botVoiceChannel = event.getClient().getOurUser().getVoiceStateForGuild(event.getGuild()).getChannel();

        if(botVoiceChannel == null)
            return;

        TrackScheduler scheduler = SongManager.getGuildAudioPlayer(event.getGuild()).getScheduler();
        scheduler.getQueue().clear();
        scheduler.nextTrack();

        botVoiceChannel.leave();
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {

    }

    @Override
    public void Testing(MessageReceivedEvent event, String[] args) {
        if (event.getAuthor().getPermissionsForGuild(event.getGuild()).contains(Permissions.MANAGE_CHANNELS)) Action(event,args);
    }
}
