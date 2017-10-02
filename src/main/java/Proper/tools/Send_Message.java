package Proper.tools;

import sx.blah.discord.handle.obj.IChannel;

import static java.lang.Thread.sleep;

/**
 * Created by Simerron on 06/07/2017.
 * Last edited by Simerron on 06/07/2017
 */
public class Send_Message{

    public void sendDelay(IChannel TextChannel, String Message, long delay){
        Type(TextChannel);
        try{sleep(delay);}
        catch (Exception e){e.printStackTrace();}
        send(TextChannel, Message);
        StopType(TextChannel);
    }

    public static void send(IChannel TextChannel, String Message){
        TextChannel.sendMessage(Message);
    }

    private void Type(IChannel TextChannel){
        TextChannel.setTypingStatus(true);
    }

    private void StopType(IChannel TextChannel){
        TextChannel.setTypingStatus(false);
    }

    public void toggleType(IChannel TextChannel){
        TextChannel.toggleTypingStatus();
    }

    public boolean isTyping (IChannel TextChannel){
        return TextChannel.getTypingStatus();
    }
}
