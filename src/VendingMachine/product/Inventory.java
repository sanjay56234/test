package VendingMachine.product;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<Product, Integer> inventory;

    public Inventory(){
        inventory = new HashMap<>();
    }

    public void updateInventory(Product product, Integer quantity){
        inventory.put(product, inventory.getOrDefault(product,0)+quantity);
    }

    public boolean hasProduct(Product product){
        return inventory.get(product) > 0;
    }

    public Integer getQuantity(Product product){
        return inventory.get(product);
    }

}
