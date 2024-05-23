package SnakeLadder2.entities;

public class Player {
    private String name;
    private Integer pos;

    public  Player(String playerName){
        this.name = playerName;
        this.pos = 0;
    }

    public void setPos(Integer pos){
        this.pos = pos;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPos(){
        return this.pos;
    }

}
