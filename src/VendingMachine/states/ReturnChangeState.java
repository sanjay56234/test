package VendingMachine.states;

import VendingMachine.enums.Coin;
import VendingMachine.enums.Note;
import VendingMachine.machine.VendingMachine;
import VendingMachine.product.Product;

public class ReturnChangeState implements VendingMachineStates{
    VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine){
        this.vendingMachine =  vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("Invalid operation");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Invalid operation");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Invalid operation");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Invalid operation");
    }

    @Override
    public void returnChange() {
        double change = vendingMachine.getPayment() - vendingMachine.selectedProduct().getPrice();
        if (change > 0) {
            System.out.println("Change returned: $" + change);
        } else {
            System.out.println("No change to return.");
        }
        vendingMachine.reset();
        vendingMachine.setCurrentState(new IdleState(vendingMachine));
    }
}
