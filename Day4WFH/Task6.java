import java.util.ArrayList;
import java.util.Collections;
public class Task6 {
    public static void main(String[] args) {
        
        ArrayList<Integer> prices = new ArrayList<>();
        prices.add(1000);
        prices.add(2500);
        prices.add(1500);
        prices.add(5000);
        prices.add(3000);
        prices.add(800);
        prices.add(4500);
        prices.add(2000);
        prices.add(3500);
        prices.add(1200);
          System.out.println("Product Prices: " + prices);
           prices.set(2, 1800);
         System.out.println("After Updating: " + prices);
          System.out.println("Highest Price: " + Collections.max(prices));
        System.out.println("Lowest Price: " + Collections.min(prices));
        int sum = 0;
         for (int price : prices) {
            sum = sum + price;
        }
         double average = (double) sum / prices.size();
        System.out.println("Average Price: " + average);
         Collections.sort(prices);
        System.out.println("Sorted Prices: " + prices);

        // Display prices within a given range
        int min = 1500;
        int max = 3500;
        System.out.println("Prices between " + min + " and " + max + ":");
        for (int price : prices) {
            if (price >= min && price <= max) {
                System.out.println(price);
    }
}
    }
}