
import java.util.LinkedHashMap;

public class Task19 {
    public static void main(String[] args) {

        LinkedHashMap<Integer, String> orders = new LinkedHashMap<>();

        // Add new orders
        orders.put(101, "Hema");
        orders.put(102, "Sneha");
        orders.put(103, "Priya");
        orders.put(104, "Keerthi");

        // Display all orders
        System.out.println("Order Details: " + orders);

        // Update customer information
        orders.put(102, "Anu");
        System.out.println("After Updating: " + orders);

        // Search for an order
        System.out.println("Order 103 Customer: " + orders.get(103));

        // Check whether order exists
        System.out.println("Order 101 Exists: " + orders.containsKey(101));

        // Cancel an order
        orders.remove(103);
        System.out.println("After Cancelling: " + orders);

        // Display final orders
        System.out.println("Final Order Details: " + orders);
    }
}