package SnakeLadder2.entities;

public class Snake {
    private  int head;
    private  int tail;

    public Snake(int head, int tail){
        this.head = head;
        this.tail = tail;
    }
    public void setHead(int head){
        this.head = head;
    }

    public void setTail(int tail){
        this.tail = tail;
    }

    public int getHead(){
        return this.head;
    }
    public int getTail(){
        return this.tail;
    }

}
