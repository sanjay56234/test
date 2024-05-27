package VendingMachine.states;

import VendingMachine.enums.Coin;
import VendingMachine.enums.Note;
import VendingMachine.machine.VendingMachine;
import VendingMachine.product.Product;

public class DispenseState implements VendingMachineStates{
    VendingMachine vendingMachine;
    public DispenseState(VendingMachine vendingMachine){
         this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("Already selected");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Already selected");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Already selected");
    }

    @Override
    public void dispenseProduct() {
        Product product = vendingMachine.selectedProduct();
        Integer quantity = vendingMachine.getInventory().getQuantity(product);

        vendingMachine.getInventory().updateInventory(product, quantity-1);
        System.out.println(String.format("Product %s is dispense", product.getName()));
        vendingMachine.setCurrentState(new ReturnChangeState(vendingMachine));
    }

    @Override
    public void returnChange() {
        System.out.println("Already selected");
    }
}
