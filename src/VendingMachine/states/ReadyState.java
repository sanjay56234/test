package VendingMachine.states;

import VendingMachine.enums.Coin;
import VendingMachine.enums.Note;
import VendingMachine.machine.VendingMachine;
import VendingMachine.product.Product;

public class ReadyState implements VendingMachineStates{

    VendingMachine vendingMachine;
    public ReadyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected");
    }

    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addCoin(coin);
        System.out.println(String.format("Coin inserted : %s", coin.getValue()));
        checkPaymentStatus();
    }

    @Override
    public void insertNote(Note note) {
        vendingMachine.addNote(note);
        System.out.println(String.format("Note inserted : %s", note.getValue()));
        checkPaymentStatus();
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Add cash first");
    }

    @Override
    public void returnChange() {
        System.out.println("Add cash first");
    }


    private void checkPaymentStatus(){
        if(vendingMachine.getPayment() >= vendingMachine.selectedProduct().getPrice()){
            vendingMachine.setCurrentState(new DispenseState(vendingMachine));
        }
    }
}
