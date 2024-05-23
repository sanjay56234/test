package SnakeLadder2.entities;

public class Ladder {
    private int top;
    private int bottom;

    public Ladder(int top, int bottom){
        this.top = top;
        this.bottom = bottom;
    }

    public void setTop(int top){
        this.top = top;
    }

    public void setBottom(int bottom){
        this.bottom = bottom;
    }

    public int getTop(){
        return this.top;
    }

    public  int getBottom(){
        return this.bottom;
    }
}
