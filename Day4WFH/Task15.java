import java.util.HashMap;
import java.util.Map;

public class Task15 {
    public static void main(String[] args) {

        HashMap<Integer, Integer> products = new HashMap<>();

        products.put(101, 10);
        products.put(102, 4);
        products.put(103, 8);
        products.put(104, 3);

        System.out.println("Product Inventory: " + products);

        products.put(101, 15);
        System.out.println("After Updating: " + products);

        int id = 103;
        int sold = 5;

        int quantity = products.getOrDefault(id, 0);
        products.put(id, quantity - sold);

        System.out.println("After Selling: " + products);

        System.out.println("Product 102 Quantity: " + products.get(102));

        System.out.println("Products Below 5:");

        for (Map.Entry<Integer, Integer> e : products.entrySet()) {
            if (e.getValue() < 5) {
                System.out.println("Product ID: " + e.getKey()
                        + ", Quantity: " + e.getValue());
            }
        }

        products.values().removeIf(q -> q == 0);

        System.out.println("Final Inventory: " + products);
    }

}
