package Proper.tools;

import sx.blah.discord.handle.obj.IChannel;

/**
 * Created by simerron on 25/07/17.
 */
public class purge {
    public static void purge (IChannel chan, int i){
        chan.getMessageHistory(i).bulkDelete().clear();
    }
}
