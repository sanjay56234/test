package CoffeeVendingMachine;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();
        coffeeMachine.getMenu();

        // Simulate user requests
        Coffee espresso = coffeeMachine.selectCoffee("Espresso");
        coffeeMachine.dispatchCoffee(espresso, new Payment(3.0));

        Coffee cappuccino = coffeeMachine.selectCoffee("Cappuccino");
        coffeeMachine.dispatchCoffee(cappuccino, new Payment(3.5));


        Coffee latte = coffeeMachine.selectCoffee("Latte");
        coffeeMachine.dispatchCoffee(latte, new Payment(4.0));
    }
}
