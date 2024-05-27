package VendingMachine.machine;


import VendingMachine.enums.Coin;
import VendingMachine.enums.Note;
import VendingMachine.product.Inventory;
import VendingMachine.product.Product;
import VendingMachine.states.IdleState;
import VendingMachine.states.VendingMachineStates;

public class VendingMachine {
    private VendingMachineStates currentState;
    private static VendingMachine instance;
    private Product product;
    private double payment;
    private Inventory inventory;

    private VendingMachine(){
        product = null;
        payment = 0.0;
        inventory = new Inventory();
        currentState = new IdleState(this);
    }

    public static synchronized VendingMachine getInstance(){
        if(instance==null){
            instance = new VendingMachine();
        }
        return instance;
    }

    public void setCurrentState(VendingMachineStates vendingMachineStates){
        this.currentState = vendingMachineStates;
    }

    public VendingMachineStates getCurrentState(){
        return this.currentState;
    }

    public void selectProduct(Product product){
        this.currentState.selectProduct(product);
    }
    public void setProduct(Product product){
        this.product = product;
    }

    public void insertCoin(Coin coin){
        this.currentState.insertCoin(coin);
    }

    public void addCoin(Coin coin){
        this.payment+=coin.getValue();
    }

    public void insertNote(Note note){
        this.currentState.insertNote(note);
    }

    public void addNote(Note note){
        this.payment+=note.getValue();
    }

    public void dispenseProduct(){
        this.currentState.dispenseProduct();
    }

    public void returnChange(){
        this.currentState.returnChange();
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public double getPayment(){
        return this.payment;
    }

    public Product selectedProduct(){
        return this.product;
    }

    public void reset(){
        this.currentState = null;
        this.product = null;
        this.payment = 0.0;
    }

}
