package DesignPatterns.DecoratorPattern.Decorators;

import DesignPatterns.DecoratorPattern.Pizza.BasePizza;

public class Mushroom extends PizzaDecorator{
    BasePizza basePizza;

    public Mushroom(BasePizza basePizza){
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return basePizza.cost() + 10;
    }
}
