import java.util.LinkedHashSet;

public class Task25 {
    public static void main(String[] args) {
        LinkedHashSet<String> products = new LinkedHashSet<>();
        products.add("Laptop");
        products.add("Mobile");
        products.add("Headphones");
        products.add("Keyboard");
        products.add("Mouse");

        System.out.println("Recently Viewed Products: " + products);

        products.add("Monitor");
        System.out.println("After Adding Product: " + products);

        products.add("Laptop");
        System.out.println("After Duplicate Addition: " + products);

        System.out.println("Laptop Viewed: " + products.contains("Laptop"));

        products.remove("Keyboard");
        System.out.println("After Removing Product: " + products);

        System.out.println("Total Viewed Products: " + products.size());
    }
}