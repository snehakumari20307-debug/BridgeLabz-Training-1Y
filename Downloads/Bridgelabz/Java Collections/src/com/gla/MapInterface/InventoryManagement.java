package com.gla.MapInterface;
import java.util.*;

public class InventoryManagement {

    private Map<String, Integer> stock = new HashMap<>();

    // 1. Add new product
    public void addProduct(String product, int quantity) {
        stock.put(product, quantity);
        System.out.println("Added: " + product + " -> " + quantity);
    }

    // 2. Customer purchase (reduce stock)
    public void purchaseProduct(String product, int quantity) {
        if (!stock.containsKey(product)) {
            System.out.println(product + " is not stocked.");
            return;
        }

        int currentQty = stock.get(product);
        int newQty = currentQty - quantity;

        if (newQty <= 0) {
            stock.remove(product); // or set to 0 if preferred
            System.out.println(product + " is now OUT OF STOCK.");
        } else {
            stock.put(product, newQty);
            System.out.println("Purchased " + quantity + " of " + product +
                    ". Remaining: " + newQty);
        }
    }

    // 3. Restock product
    public void restockProduct(String product, int quantity) {
        stock.put(product, stock.getOrDefault(product, 0) + quantity);
        System.out.println("Restocked: " + product + " + " + quantity);
    }

    // 4. Query product stock
    public void checkStock(String product) {
        if (stock.containsKey(product)) {
            System.out.println(product + " in stock: " + stock.get(product));
        } else {
            System.out.println(product + " is not stocked.");
        }
    }

    // Print out-of-stock products
    public void printOutOfStock() {
        System.out.println("\n--- Out of Stock Products ---");

        // If we removed items when stock is 0
        if (stock.isEmpty()) {
            System.out.println("All products are out of stock OR none exist.");
            return;
        }

        // If we wanted to track zero stock products instead
        boolean found = false;
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println(entry.getKey());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No products are exactly zero in stock.");
        }
    }

    // Show full inventory
    public void showInventory() {
        System.out.println("\n--- Current Inventory ---");
        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        InventoryManagement store = new InventoryManagement();

        // 1. Add products
        store.addProduct("Milk", 10);
        store.addProduct("Bread", 5);
        store.addProduct("Eggs", 12);

        // 2. Purchases
        store.purchaseProduct("Milk", 3);
        store.purchaseProduct("Bread", 5); // becomes out of stock
        store.purchaseProduct("Butter", 2); // not stocked

        // 3. Restock
        store.restockProduct("Bread", 10);
        store.restockProduct("Butter", 4);

        // 4. Check stock
        store.checkStock("Milk");
        store.checkStock("Butter");

        // Show inventory
        store.showInventory();

        // Out of stock list
        store.printOutOfStock();
    }
}

