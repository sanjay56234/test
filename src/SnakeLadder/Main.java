package SnakeLadder;

import SnakeLadder.entities.Board;
import SnakeLadder.services.GamePlay;
import SnakeLadder.entities.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake Ladder Game");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of snakes in game");
        int snakes = scanner.nextInt();
        Board board = Board.getInstance();
        System.out.println("Enter the snakes position");
        while(snakes > 0){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            board.setSnakePosition(start, end);
            snakes--;
        }
        System.out.println("Enter the number of ladder in game");
        int ladder = scanner.nextInt();
        System.out.println("Enter the ladder position");
        while(ladder > 0){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            board.setLadderPosition(start, end);
            ladder--;
        }
        Player player = Player.getInstance();
        System.out.println("Enter the no of player ");
        int players =  scanner.nextInt();
        scanner.nextLine();
        while(players > 0){
            String playerName = scanner.nextLine();
            player.addPlayer(playerName);
            players--;
        }
        GamePlay gamePlay = GamePlay.getInstance();
        System.out.println(String.format("Winner of game is : %s", gamePlay.startGame()));
        scanner.close();
    }
}