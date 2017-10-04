package Proper.tools;

import Proper.Command;
import Proper.commands.*;
import Proper.commands.PlayerCommands.*;
import Proper.tools.lavaplayer.GuildMusicManager;
import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;

import java.util.HashMap;
import java.util.Map;

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
        cmd.put("leave", new LeaveCommand());
        cmd.put("play", new PlaySongCommand());
        cmd.put("skip", new SkipSongCommand());
        cmd.put("volume", new VolumeCommand());
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
