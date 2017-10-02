package Proper.tools;

import Proper.commands.PurgeCommand;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.ArrayList;

/**
 * Created by Simerron on 06/07/2017.
 * Last edited by Simerron on 06/07/2017
 */
public class Message_handler {

    private Command_Handler Command_Handler;

    public void handle(MessageReceivedEvent event){
        String Raw;
        String Beheaded;
        String[] args;
        ArrayList<String> split = new ArrayList<String>();
        String invoke;

        //System.out.println("Message is Handling");
        if(event.getMessage().getContent().startsWith(".")){
            Raw = event.getMessage().getContent();
            Beheaded = Raw.replaceFirst(".", "");
            args = Beheaded.split(" ");
            for (String s : args) {
                split.add(s);
            }
            invoke = split.remove(0);
            args = new String[args.length - 1];
            int i = 0;
            for (String s : split) {
                args[i] = s;
                i++;
            }
            Command_Handler.handle(event, args, invoke);
        }else {
            //System.out.println("Message Handled Without command");
            if (event.getChannel() == event.getGuild().getChannelsByName("perron-du-bar").get(0)){
                if (event.getMessage().getContent().startsWith("Je pousse la porte")) {
                    event.getAuthor().removeRole(event.getGuild().getRolesByName("Vagabond").get(0));
                    event.getAuthor().addRole(event.getGuild().getRolesByName("PJ").get(0));
                    Send_Message.send(event.getChannel(), "Bienvenu "+event.getAuthor().mention()+" tu peut maintenant découvrir les habitants de ce merveilleux serveur !");
                    purge.purge(event.getChannel(), 99);
                }
            }
        }
        return;
    }

    public Message_handler() {
        this.Command_Handler = new Command_Handler();
    }
}
