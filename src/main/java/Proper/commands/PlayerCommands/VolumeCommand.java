package Proper.commands.PlayerCommands;

import Proper.Command;
import Proper.Main;
import Proper.tools.Send_Message;
import Proper.tools.lavaplayer.SongManager;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IVoiceChannel;

public class VolumeCommand implements Command {
    @Override
    public void Help(MessageReceivedEvent event) {

    }

    @Override
    public void Action(MessageReceivedEvent event, String[] args) {
        IVoiceChannel botVoiceChannel = event.getClient().getOurUser().getVoiceStateForGuild(event.getGuild()).getChannel();

        if (botVoiceChannel == null) {
            IVoiceChannel userVoiceChannel = event.getAuthor().getVoiceStateForGuild(event.getGuild()).getChannel();

            if (userVoiceChannel == null)
                return;
        }
        if (args.length < 1)
            Send_Message.send(event.getChannel(), "Current volume is " + SongManager.getGuildAudioPlayer(event.getGuild()).getVolume());
        else {
            try {
                int newVolume = Math.max(10, Math.min(100, Integer.parseInt(args[0])));
                if (SongManager.getGuildAudioPlayer(event.getGuild()).getVolume() > newVolume) {
                    Send_Message.send(event.getChannel(), "Now playing Lower :point_down:");
                } else {
                    Send_Message.send(event.getChannel(), "Now playing Louder :metal:");
                }
                SongManager.getGuildAudioPlayer(event.getGuild()).setVolume(newVolume);

            } catch (NumberFormatException e) {
                Send_Message.send(event.getChannel(), "Volume is between 10 and 100");
            }
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
