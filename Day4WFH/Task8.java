import java.util.HashSet;
public class Task8 {
    public static void main(String[] args) {
           HashSet<String> products = new HashSet<>();
        products.add("Laptop");
        products.add("Mobile");
        products.add("Keyboard");
        products.add("Mouse");
        products.add("Headphones");
         System.out.println("Product Inventory: " + products);
        products.add("Laptop");
        products.add("Mobile");
         System.out.println("After Adding Duplicates: " + products);

          products.add("Monitor");
        System.out.println("After Adding New Product: " + products);

         products.remove("Mouse");
        System.out.println("After Removing Product: " + products);

         System.out.println("Is Laptop Available? " + products.contains("Laptop"));

        System.out.println("Total Unique Products: " + products.size());

    }
}
