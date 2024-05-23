package SnakeLadder.entities;

import java.util.Random;

public class Dice {

    static  Dice dice;

    public static Dice getInstance(){
        if(dice == null) return new Dice();
        return dice;
    }

    public int getDiceNumber(){
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

}
