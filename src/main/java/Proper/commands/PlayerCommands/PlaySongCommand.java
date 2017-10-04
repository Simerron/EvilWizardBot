package Proper.commands.PlayerCommands;

import Proper.Command;
import Proper.tools.Command_Handler;
import Proper.tools.Send_Message;
import Proper.tools.lavaplayer.SongManager;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IVoiceChannel;

public class PlaySongCommand implements Command {
    @Override
    public void Help(MessageReceivedEvent event) {

    }

    @Override
    public void Action(MessageReceivedEvent event, String[] args) {

        IVoiceChannel botVoiceChannel = event.getClient().getOurUser().getVoiceStateForGuild(event.getGuild()).getChannel();

        if(botVoiceChannel == null) {
            IVoiceChannel userVoiceChannel = event.getAuthor().getVoiceStateForGuild(event.getGuild()).getChannel();

            if(userVoiceChannel == null)
                return;
            userVoiceChannel.join();
        }

        for (String url: args) {
            SongManager.loadAndPlay(event.getChannel(), url);
        }
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {

    }

    @Override
    public void Testing(MessageReceivedEvent event, String[] args) {
        Action(event, args);
    }
}
