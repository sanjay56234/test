package DesignPatterns.DecoratorPattern;

import DesignPatterns.DecoratorPattern.Decorators.Cheese;
import DesignPatterns.DecoratorPattern.Decorators.Mushroom;
import DesignPatterns.DecoratorPattern.Pizza.BasePizza;
import DesignPatterns.DecoratorPattern.Pizza.PannerPizza;

public class Main {
    public static void main(String[] args) {

        BasePizza basePizza = new PannerPizza();

        basePizza  = new Mushroom(basePizza);
        System.out.println(basePizza.cost());

        basePizza = new Cheese(basePizza);
        System.out.println(basePizza.cost());

        basePizza = new Mushroom(basePizza);
        System.out.println(basePizza.cost());

    }
}
