package Proper.tools;

import java.util.Random;

/**
 * Created by Simerron on 31/03/2017.
 */
public class random_game_state {

    private static Random ran = new Random();

    public random_game_state() {
        ran.setSeed(ran.nextLong());
    }

    public int getRan(int nbMax){
        ran.setSeed(ran.nextLong());
        return ran.nextInt(nbMax) + 1;
    }
}
