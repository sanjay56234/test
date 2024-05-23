package SnakeLadder2.services;

import SnakeLadder2.entities.Dice;
import SnakeLadder2.entities.Player;
import SnakeLadder2.entities.Ladder;
import SnakeLadder2.entities.Snake;

import java.util.*;

public class SnakeAndLadder {

    Dice dice;
    int winPos;
    HashMap<Integer, Integer> snakePosition;
    HashMap<Integer,Integer> ladderPosition;
    Queue<Player> players = new LinkedList<>();

    public SnakeAndLadder(Dice dice, int n, int m, List<Snake> snakes, List<Ladder>ladders){
            winPos = n*m;
            this.dice = dice;
            snakePosition = new HashMap<>();
            ladderPosition = new HashMap<>();
            for(Snake snake : snakes){
                snakePosition.put(snake.getHead(), snake.getTail());
            }
            for(Ladder ladder : ladders){
                ladderPosition.put(ladder.getTop(), ladder.getBottom());
            }
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void playGame(){
        while(true){
            if(players.size() <= 1){
                System.out.println("More than 1 player needed to play");
                return ;
            }

            Player player = players.remove();

            if(checkPlayerWinner(player)){
                System.out.println(String.format("%s is winner", player.getName()));
                return ;
            }else{
                players.add(player);
            }
        }
    }


    private boolean checkPlayerWinner(Player player){
        int currentPosition = player.getPos();
        int move = dice.getNextMove();
        int updatedPos = getUpdatePosition(currentPosition, move);

        System.out.println(String.format("%s moves %s from %s reach to : %s", player.getName(), move, currentPosition, updatedPos));

        if(updatedPos == winPos){
            return true;
        }else if(updatedPos > winPos){
            return false;
        }else{
            player.setPos(updatedPos);
            return false;
        }
    }

    private int getUpdatePosition(int current, int move){
        int updated = current + move;
        while (snakePosition.containsKey(updated) || ladderPosition.containsKey(updated)){
            if(snakePosition.containsKey(updated)){
                updated = snakePosition.get(updated);
            }else{
                updated = ladderPosition.get(updated);
            }
        }
        return updated;
    }

}
