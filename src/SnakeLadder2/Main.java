package SnakeLadder2;

import SnakeLadder2.entities.Dice;
import SnakeLadder2.entities.Ladder;
import SnakeLadder2.entities.Player;
import SnakeLadder2.entities.Snake;
import SnakeLadder2.services.SnakeAndLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to snake and ladder game");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Dice Size, Board Size");
        int diceSize = scanner.nextInt();
        Dice dice = new Dice(diceSize);

        int row, col;
        row = scanner.nextInt();
        col = scanner.nextInt();
        List<Snake> snakeList = new ArrayList<>();
        List<Ladder> ladderList = new ArrayList<>();
        System.out.println("Enter Number of Snakes");
        int snakesSize = scanner.nextInt();
        System.out.println("Enter head and tail of snakes");
        while (snakesSize > 0){
            int head = scanner.nextInt();
            int tail = scanner.nextInt();
            Snake snake = new Snake(head, tail);
            snakeList.add(snake);
            snakesSize-=1;
        }
        System.out.println("Enter Number of Ladders");
        int ladderSize = scanner.nextInt();
        System.out.println("Enter ladder top and bottom");
        while (ladderSize > 0){
            int top = scanner.nextInt();
            int bottom = scanner.nextInt();
            Ladder ladder = new Ladder(top, bottom);
            ladderList.add(ladder);
            ladderSize-=1;
        }

        System.out.println("Enter Number of Player");
        int playerSize = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Players Name");
        SnakeAndLadder snakeAndLadder = new SnakeAndLadder(dice, row, col, snakeList, ladderList);
        while (playerSize > 0){
            String playerName = scanner.nextLine();
            Player player = new Player(playerName);
            snakeAndLadder.addPlayer(player);
            playerSize-=1;
        }
        snakeAndLadder.playGame();
        scanner.close();

    }
}
