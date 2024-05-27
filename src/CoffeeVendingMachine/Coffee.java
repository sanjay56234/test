package CoffeeVendingMachine;

import java.util.List;
import java.util.Map;

public class Coffee {
    String name;
    double price;

    Map<Ingredient, Integer> ingredientMap;

    public Coffee(String name, double price, Map<Ingredient, Integer> ingredientMap) {
        this.name = name;
        this.price = price;
        this.ingredientMap = ingredientMap;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Map<Ingredient, Integer> getIngredientMap() {
        return ingredientMap;
    }

    public void setIngredientMap(Map<Ingredient, Integer> ingredientMap) {
        this.ingredientMap = ingredientMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
