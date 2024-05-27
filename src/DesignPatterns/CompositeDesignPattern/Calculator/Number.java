package DesignPatterns.CompositeDesignPattern.Calculator;

public class Number implements Expression{

    Integer num;

    public Number(Integer n){
        this.num  = n;
    }
    @Override
    public Integer evaluate() {
        return num;
    }
}
