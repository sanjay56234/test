package VendingMachine.states;


import VendingMachine.enums.Coin;
import VendingMachine.enums.Note;
import VendingMachine.product.Product;

public interface VendingMachineStates {
    public void selectProduct(Product product);

    public void insertCoin(Coin coin);
    public void insertNote(Note note);
    public void dispenseProduct();
    public void returnChange();

}
