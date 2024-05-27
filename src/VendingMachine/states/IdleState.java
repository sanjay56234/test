package VendingMachine.states;

import VendingMachine.product.Product;
import VendingMachine.enums.Coin;
import VendingMachine.enums.Note;
import VendingMachine.machine.VendingMachine;

public class IdleState implements VendingMachineStates{

    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(Product product) {
        if(vendingMachine.getInventory().hasProduct(product)){
            vendingMachine.setProduct(product);
            vendingMachine.setCurrentState(new ReadyState(vendingMachine));
        }else{
            System.out.println(String.format("Not enough quantity present of %s", product.getName()));
        }
    }


    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Select product first");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Select product first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Select product first");
    }

    @Override
    public void returnChange() {
        System.out.println("Select product first");
    }
}
