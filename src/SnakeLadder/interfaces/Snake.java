package SnakeLadder.interfaces;

import java.util.HashMap;

public interface Snake {

    HashMap<Integer,Integer> snakePosition = new HashMap<>();

    void setSnakePosition(Integer start, Integer end);

    Boolean checkSnakePosition(Integer position);

    Integer getTailPosition(Integer start);

}
