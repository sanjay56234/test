package SnakeLadder.services;

import SnakeLadder.entities.Board;
import SnakeLadder.entities.Dice;
import SnakeLadder.entities.Player;

public class GamePlay {

    Player player = Player.getInstance();
    Board board = Board.getInstance();
    Dice dice = Dice.getInstance();
    static GamePlay gamePlay;
    public static GamePlay getInstance(){
        if(gamePlay==null){
            return new GamePlay();
        }
        return gamePlay;
    }
    public String startGame(){
        while(true){
            Integer currentPlayerId = player.getCurrentPlayer();
            String  currentPlayerName = player.getPlayerName(currentPlayerId);
            Integer currentPosition = player.getPlayerPosition(currentPlayerId);
            Integer moves = dice.getDiceNumber();
            Integer newPosition = calculateNewPosition(currentPosition, moves, currentPlayerName);
            System.out.println(String.format("%s moves %s and reach to : %s", currentPlayerName, moves, newPosition));
            if(isPlayerWinner(newPosition)){
                return currentPlayerName;
            }else{
                player.updatePlayerPosition(currentPlayerId, newPosition);
                player.removeCurrentPlayer();
            }
        }
    }

    private Boolean isPlayerWinner(Integer currentPosition){
        return currentPosition.equals(100);
    }

    private Integer calculateNewPosition(Integer currentPosition, Integer moves, String playerName){
        Integer newPos = currentPosition + moves;
        while( board.checkSnakePosition(newPos) || board.checkLadderPosition(newPos) ){
            if(board.checkSnakePosition(newPos)){
                newPos = board.getTailPosition(newPos);
                System.out.println(String.format("%s bitten by snake and reach to %s", playerName, newPos));
            }else{
                newPos = board.getTopPosition(newPos);
                System.out.println(String.format("%s taken the ladder and reach to %s", playerName, newPos));
            }
        }
        return newPos;
    }

}
