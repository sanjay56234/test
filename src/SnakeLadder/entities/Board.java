package SnakeLadder.entities;

import SnakeLadder.interfaces.Ladder;
import SnakeLadder.interfaces.Snake;

public class Board implements Snake, Ladder {

    static Board board;

    public  static  Board getInstance(){
        if(board == null) return new Board();
        return board;
    }
    @Override
    public void setLadderPosition(Integer start, Integer end) {
        Board.ladderPosition.put(start, end);
    }

    @Override
    public Boolean checkLadderPosition(Integer position) {
        return Board.ladderPosition.containsKey(position);
    }

    @Override
    public Integer getTopPosition(Integer start) {
        return Board.ladderPosition.get(start);
    }

    @Override
    public void setSnakePosition(Integer start, Integer end) {
        Board.snakePosition.put(start,end);
    }

    @Override
    public Boolean checkSnakePosition(Integer position) {
        return Board.snakePosition.containsKey(position);
    }

    @Override
    public Integer getTailPosition(Integer start) {
        return Board.snakePosition.get(start);
    }

}
