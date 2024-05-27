package DesignPatterns.DecoratorPattern.Decorators;

import DesignPatterns.DecoratorPattern.Pizza.BasePizza;

public class Cheese extends PizzaDecorator{
    BasePizza basePizza;

    public Cheese(BasePizza basePizza){
        this.basePizza = basePizza;
    }
    @Override
    public int cost() {
        return basePizza.cost() + 20;
    }
}
