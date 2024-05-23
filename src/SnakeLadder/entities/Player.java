package SnakeLadder.entities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Player {

    static int playerId;

    static private Queue<Integer> playersQueue;

    static private HashMap<Integer,Integer> playerPosition;

    static private HashMap<Integer, String> playerInfo;

    static Player playerInstance;

    Player(){
        playersQueue = new LinkedList<>();
        playerPosition = new HashMap<>();
        playerInfo = new HashMap<>();
        playerId = 1;
    }
    public static Player getInstance(){
        if(playerInstance == null){
            return new Player();
        }
        return playerInstance;
    }
    private void setPlayersQueue(Integer playerId){
        playersQueue.add(playerId);
    }

    public Integer getCurrentPlayer(){
        if(playersQueue.isEmpty()){
            System.out.println("Player Queue is empty");
        }
        return playersQueue.peek();
    }

    public void removeCurrentPlayer(){
        if(playersQueue.isEmpty()){
            System.out.println("Player Queue is empty");
            return ;
        }
        int frontPlayer = playersQueue.peek();
        playersQueue.remove();
        playersQueue.add(frontPlayer);
    }

    public void addPlayer(String playerName){
        playerInfo.put(playerId, playerName);
        playerPosition.put(playerId, 0);
        setPlayersQueue(playerId++);
    }

    public Integer getPlayerPosition(Integer playerId){
        if(!playerPosition.containsKey(playerId)){
            System.out.println("Player Id is invalid");
            return -1;
        }
        return playerPosition.get(playerId);
    }

    public void updatePlayerPosition(Integer playerId, Integer newPos){
        playerPosition.put(playerId, newPos);
    }
    public String getPlayerName(Integer playerId){
        return playerInfo.get(playerId);
    }

}
