package Proper;

import Proper.tools.d4j_tool.annot_Listener;
import Proper.tools.d4j_tool.client_Maker;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;


public class Main {

    private static IDiscordClient Client;

    public Main() {
    }

    public static void main(String[] args) {
        String token = "";
        if (args.length == 0) { //Vérification Token
            System.out.println("Please use a Token to link the bot with discord");
            return;
        } else {
            token = args[0];
        }

        IDiscordClient client = client_Maker.createClient(token, true); //Création du bot avec login auto
        EventDispatcher dispatcher = client.getDispatcher(); //Récupération des Events
        dispatcher.registerListener(new annot_Listener());
        Client = client;
    }

    public static IDiscordClient getClient() {
        return Client;
    }

    public static void changeGame(String game_Text){Client.changePlayingText(game_Text);}

}
