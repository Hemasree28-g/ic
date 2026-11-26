  import java.util.ArrayList;
public class Task2 {
    public static void main(String[] args) {
        ArrayList<String> cart = new ArrayList<>();
        ArrayList<Integer> quantity = new ArrayList<>();

        // Add products to cart
        cart.add("Laptop");
        quantity.add(1);

        cart.add("Mobile");
        quantity.add(2);

        cart.add("Headphones");
        quantity.add(1);

        cart.add("Keyboard");
        quantity.add(3);
        System.out.println("Shopping Cart: " + cart);
        int index = cart.indexOf("Mobile");
        if (index != -1) {
            cart.remove(index);
            quantity.remove(index);
        }
        System.out.println("After Removing: " + cart);
        quantity.set(0, 2);
        System.out.println("Updated Quantity: " + quantity);
        System.out.println("Cart Products:");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i) + " - Quantity: " + quantity.get(i));
        }
        System.out.println("Is Laptop Available? " + cart.contains("Laptop"));
        int total = 0;
        for (int q : quantity) {
            total = total + q;
        }
        System.out.println("Total Products: " + total);

        cart.clear();
        quantity.clear();

        System.out.println("After Checkout: " + cart);
    }

}
