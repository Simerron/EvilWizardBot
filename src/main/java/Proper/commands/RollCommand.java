package Proper.commands;

import Proper.Command;
import Proper.tools.Send_Message;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.Random;

/**
 * Created by Simerron on 06/07/2017.
 * Last edited by Simerron on 06/07/2017
 */
public class RollCommand implements Command {

    @Override
    public void Help(MessageReceivedEvent event) {
        Send_Message Message_Sender = new Send_Message();
        Message_Sender.sendDelay(event.getChannel(), "```This is a Dice Roller Command, means that it will generate a random number just like if you roll some dices\n\nThe Syntaxe to use this command is :\n.r [Number of dices]d<Number of faces>```", 500);
    }

    @Override
    public void Action(MessageReceivedEvent event, String[] args) {
        Random ran = new Random();
        event.getMessage().delete();
        ran.setSeed(ran.nextLong());
        int nb, nbDice, faces, die;
        long result = 0;
        String message = event.getAuthor().mention() + " rolled " + args[0] + "[";
        String[] dice = args[0].split("d");
        if (dice.length == 0) {
            System.out.println("Error args");
            nbDice = 0;
            faces = 0;
        } else if (dice[0].length() == 0) {
            nbDice = 1;
        } else {
            nbDice = Integer.parseInt(dice[0]);
        }
        faces = Integer.parseInt(dice[1]);
        for (nb = 0; nb < nbDice; nb++) {
            die = ran.nextInt(faces) + 1;
            result += die;
            message = message + die + ", ";
        }
        message = message.substring(0, message.length() - 2);
        message += "] = " + result;
        Send_Message Message_Sender = new Send_Message();
        Message_Sender.sendDelay(event.getChannel(), message, 500);
    }

    @Override
    public void execute(MessageReceivedEvent event, String[] args) {

    }

    @Override
    public void Testing(MessageReceivedEvent event, String[] args) {
        Action(event, args);
    }
}
