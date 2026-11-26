import java.util.LinkedHashMap;
import java.util.Map;
public class Task20 {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> sales = new LinkedHashMap<>();
        sales.put("Laptop", 10);
        sales.put("Mobile", 20);
        sales.put("Keyboard", 15);
        sales.put("Mouse", 25);
         System.out.println("Sales Report: " + sales);
        sales.put("Laptop", 15);
        System.out.println("After Updating: " + sales);
        int total = 0;
        for (int quantity : sales.values()) {
            total = total + quantity;
        }
        int highestSales = 0;
        String productName = "";
        for (Map.Entry<String, Integer> e : sales.entrySet()) {
            if (e.getValue() > highestSales) {
                highestSales = e.getValue();
                productName = e.getKey();
            }
        }
        System.out.println("Highest Selling Product: " + productName);
        System.out.println("Highest Sales Quantity: " + highestSales);
        System.out.println("Final Sales Report:");

        for (Map.Entry<String, Integer> e : sales.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }
    }
    
}
