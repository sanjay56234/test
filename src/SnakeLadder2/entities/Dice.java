package SnakeLadder2.entities;

import java.util.Random;

public class Dice {
    private int num;

    public Dice(int num){
        this.num = num;
    }

    public int getNextMove(){
        Random random = new Random();
        return random.nextInt(this.num) + 1;
    }
}
