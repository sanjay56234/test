package CoffeeVendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeMachine {

    private static final CoffeeMachine instance = new CoffeeMachine();
    private final List<Coffee> coffee;
    private final Map<String,Ingredient> ingredientMap;

    public static CoffeeMachine getInstance(){
        return instance;
    }
    private CoffeeMachine(){
        this.coffee = new ArrayList<>();
        this.ingredientMap = new HashMap<>();
        initializeIngredients();
        initializeCoffee();
    }

    private void initializeIngredients(){
        ingredientMap.put("Coffee", new Ingredient("Coffee", 10));
        ingredientMap.put("Water", new Ingredient("Water", 10));
        ingredientMap.put("Milk", new Ingredient("Milk", 10));
    }

    private void initializeCoffee(){
        Map<Ingredient, Integer> espressoRecipe = new HashMap<>();
        espressoRecipe.put(ingredientMap.get("Coffee"), 1);
        espressoRecipe.put(ingredientMap.get("Water"), 1);
        coffee.add(new Coffee("Espresso", 2.5, espressoRecipe));

        Map<Ingredient, Integer> cappuccinoRecipe = new HashMap<>();
        cappuccinoRecipe.put(ingredientMap.get("Coffee"), 1);
        cappuccinoRecipe.put(ingredientMap.get("Water"), 1);
        cappuccinoRecipe.put(ingredientMap.get("Milk"), 1);
        coffee.add(new Coffee("Cappuccino", 3.5, cappuccinoRecipe));

        Map<Ingredient, Integer> latteRecipe = new HashMap<>();
        latteRecipe.put(ingredientMap.get("Coffee"), 1);
        latteRecipe.put(ingredientMap.get("Water"), 1);
        latteRecipe.put(ingredientMap.get("Milk"), 2);
        coffee.add(new Coffee("Latte", 4.0, latteRecipe));
    }

    public void getMenu(){
        for(Coffee coffee : coffee){
            System.out.println(String.format("%s : %s", coffee.name, coffee.price));
        }
    }

    public synchronized Coffee selectCoffee(String name){
        for(Coffee coffee : coffee){
            if(coffee.name.equals(name)) return coffee;
        }
        return null;
    }

    public synchronized void dispatchCoffee(Coffee coffee, Payment payment){
        if(payment.amount >= coffee.price){
            if (hasEnoughIngredients(coffee)) {
                updateIngredients(coffee);
                System.out.println("Dispensing " + coffee.getName() + "...");
                double change = payment.amount - coffee.getPrice();
                if (change > 0) {
                    System.out.println("Please collect your change: $" + change);
                }
            } else {
                System.out.println("Insufficient ingredients to make " + coffee.getName());
            }
        }else{
            System.out.println("Not sufficient amount");
        }
    }
    private boolean hasEnoughIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> entry : coffee.ingredientMap.entrySet()) {
            Ingredient ingredient = entry.getKey();
            int requiredQuantity = entry.getValue();
            if (ingredient.getQuantity() < requiredQuantity) {
                return false;
            }
        }
        return true;
    }

    private void updateIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> entry : coffee.ingredientMap.entrySet()) {
            Ingredient ingredient = entry.getKey();
            int requiredQuantity = entry.getValue();
            ingredient.setQuantity(-requiredQuantity);
            if (ingredient.getQuantity() < 3) {
                System.out.println("Low inventory alert: " + ingredient.getName());
            }
        }
    }

}
