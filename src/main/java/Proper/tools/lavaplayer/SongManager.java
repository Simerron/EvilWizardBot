package Proper.tools.lavaplayer;

import Proper.Main;
import Proper.tools.Send_Message;
import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException;
import com.sedmelluq.discord.lavaplayer.track.AudioPlaylist;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;

public class SongManager {

    public static synchronized GuildMusicManager getGuildAudioPlayer(IGuild guild) {
        long guildId = guild.getLongID();
        GuildMusicManager musicManager = Main.getMusicManagers().get(guildId);

        if (musicManager == null) {
            musicManager = new GuildMusicManager(Main.getPlayerManager());
            Main.getMusicManagers().put(guildId, musicManager);
        }

        guild.getAudioManager().setAudioProvider(musicManager.getAudioProvider());

        return musicManager;
    }

    public static void loadAndPlay(final IChannel channel, final String trackUrl) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());

        Main.getPlayerManager().loadItemOrdered(musicManager, trackUrl, new AudioLoadResultHandler() {
            @Override
            public void trackLoaded(AudioTrack track) {
                Send_Message.send(channel, "__" + track.getInfo().title + "__ is now in playlist.");

                play(musicManager, track);
            }

            @Override
            public void playlistLoaded(AudioPlaylist playlist) {
                AudioTrack firstTrack = playlist.getSelectedTrack();

                if (firstTrack == null) {
                    firstTrack = playlist.getTracks().get(0);
                }

                Send_Message.send(channel, "__" + firstTrack.getInfo().title + "__ is now in playlist.");

                play(musicManager, firstTrack);
            }

            @Override
            public void noMatches() {
                Send_Message.send(channel, "Arrrg I suck in Divination School be more specific than : " + trackUrl);
            }

            @Override
            public void loadFailed(FriendlyException exception) {
                Send_Message.send(channel, "My spells were blocked :  " + exception.getMessage());
            }
        });
    }

    private static void play(GuildMusicManager musicManager, AudioTrack track) {

        musicManager.getScheduler().queue(track);
    }

    public static void skipTrack(IChannel channel) {
        GuildMusicManager musicManager = getGuildAudioPlayer(channel.getGuild());
        musicManager.getScheduler().nextTrack();

        Send_Message.send(channel, "NEXT !");
    }
}

