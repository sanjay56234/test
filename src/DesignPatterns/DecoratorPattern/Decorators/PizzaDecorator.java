package DesignPatterns.DecoratorPattern.Decorators;

import DesignPatterns.DecoratorPattern.Pizza.BasePizza;

public abstract class PizzaDecorator extends BasePizza {
    BasePizza basePizza;
    public abstract int cost();
}
