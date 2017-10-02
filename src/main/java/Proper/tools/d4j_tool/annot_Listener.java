package Proper.tools.d4j_tool;

import Proper.Main;
import Proper.tools.Message_handler;
import Proper.tools.Send_Message;
import Proper.tools.fileReader;
import Proper.tools.random_game_state;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.impl.events.guild.member.UserJoinEvent;

/**
 * Created by Simerron on 06/07/2017.
 * Last edited by Simerron on 06/07/2017
 */
public class annot_Listener {
    Message_handler Handler = new Message_handler();
    @EventSubscriber
    public void onReadyEvent(ReadyEvent event) {
    }

    @EventSubscriber
    public void onMessageReceivedEvent(MessageReceivedEvent event) {
        //System.out.println("Event Received");
        Handler.handle(event);
    }

    @EventSubscriber
    public void onUserJoinEvent(UserJoinEvent event){
        event.getUser().addRole(event.getGuild().getRolesByName("Vagabond").get(0));
        Send_Message.send(event.getGuild().getChannelsByName("perron-du-bar").get(0), "Bonjour "+event.getUser().mention()+" Içi serveur de jeu de rôle, discussion Rp, conseil entre rolliste, la seule rêgle est la bienséance (pas d'insulte peut importe la raison), si vous avez un problème contacter les Modos. Pour entrer veulliez écrire 'Je pousse la porte'");
    }

}
