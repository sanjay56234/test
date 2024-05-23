package SnakeLadder.interfaces;

import java.util.HashMap;

public interface Ladder {
    HashMap<Integer,Integer> ladderPosition = new HashMap<>();

    void setLadderPosition(Integer start, Integer end);

    Boolean checkLadderPosition(Integer position);

    Integer getTopPosition(Integer start);
}
