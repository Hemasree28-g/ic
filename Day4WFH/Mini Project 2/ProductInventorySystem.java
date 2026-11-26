import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.Collections;
import java.util.Scanner;

public class ProductInventorySystem {

    static Scanner sc = new Scanner(System.in);

    static HashSet<String> hash = new HashSet<>();

    static TreeSet<String> sortedCategories = new TreeSet<>();

    // LinkedHashSet - Store product names in insertion order
    static LinkedHashSet<String> recentProducts = new LinkedHashSet<>();

    // HashMap - Store Product ID and Quantity
    static HashMap<Integer, Integer> inventory = new HashMap<>();

    // Additional HashMaps for product details
    static HashMap<Integer, String> productNames = new HashMap<>();
    static HashMap<Integer, String> productCategories = new HashMap<>();
    static HashMap<Integer, Double> productPrices = new HashMap<>();


    // Main Method
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("       PRODUCT INVENTORY SYSTEM");
            System.out.println("1. Add Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product Quantity");
            System.out.println("5. Sell Product");
            System.out.println("6. Remove Product");
            System.out.println("7. Add Product Category");
            System.out.println("8. Display Unique Categories");
            System.out.println("9. Display Sorted Categories");
            System.out.println("10. Display Recently Added Products");
            System.out.println("11. Generate Inventory Report");
            System.out.println("12. Exit");

            choice = readInt("\nEnter Your Choice: ");

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    displayProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    updateQuantity();
                    break;

                case 5:
                    sellProduct();
                    break;

                case 6:
                    removeProduct();
                    break;

                case 7:
                    addCategory();
                    break;

                case 8:
                    displayCategories();
                    break;

                case 9:
                    displaySortedCategories();
                    break;

                case 10:
                    displayRecentProducts();
                    break;

                case 11:
                    generateReport();
                    break;

                case 12:
                    System.out.println("Thank You for Using Product Inventory System!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 12);

        sc.close();
    }


    static int readInt(String message) {

        while (true) {

            System.out.print(message);

            try {

                return Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {

                System.out.println("Please Enter a Valid Number!");
            }
        }
    }

    static int readPositiveInt(String message) {

        while (true) {

            int value = readInt(message);

            if (value > 0) {
                return value;
            }

            System.out.println("Value Must Be Greater Than Zero!");
        }
    }


    static String readString(String message) {

        while (true) {

            System.out.print(message);

            String value = sc.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Input Cannot Be Empty!");
        }
    }

    static double readPrice() {

        while (true) {

            System.out.print("Enter Product Price: ");

            try {

                double price = Double.parseDouble(sc.nextLine().trim());

                if (Double.isFinite(price) && price > 0) {
                    return price;
                }

                System.out.println("Enter a Valid Positive Price!");

            } catch (NumberFormatException e) {

                System.out.println("Please Enter a Valid Price!");
            }
        }
    }


    // Module 1: Add Product
    static void addProduct() {

        System.out.println("\n---------- ADD PRODUCT ----------");

        int id = readPositiveInt("Enter Product ID: ");

        if (inventory.containsKey(id)) {

            System.out.println("Product ID Already Exists!");
            return;
        }

        String name = readString("Enter Product Name: ");

        if (recentProducts.contains(name)) {

            System.out.println("Product Name Already Exists!");
            return;
        }

        String category = readString("Enter Product Category: ");

        double price = readPrice();

        int quantity = readInt("Enter Available Quantity: ");

        if (quantity < 0) {

            System.out.println("Quantity Cannot Be Negative!");
            return;
        }

        inventory.put(id, quantity);

        productNames.put(id, name);

        productCategories.put(id, category);

        productPrices.put(id, price);

        hash.add(category);

        recentProducts.add(name);

        System.out.println("Product Added Successfully!");
    }


    // Module 2: Display All Products
    static void displayProducts() {

        System.out.println("\n---------- PRODUCT INVENTORY ----------");

        if (inventory.isEmpty()) {

            System.out.println("No Product Records Found!");
            return;
        }

        System.out.printf("%-10s %-15s %-15s %-12s %-10s%n",
                "ID", "Product", "Category", "Price", "Quantity");

        for (int id : inventory.keySet()) {

            System.out.printf("%-10d %-15s %-15s %-12.2f %-10d%n",
                    id,
                    productNames.get(id),
                    productCategories.get(id),
                    productPrices.get(id),
                    inventory.get(id));
        }

        System.out.println("-----------------------------------------------");

        System.out.println("Total Products: " + inventory.size());
    }


    // Module 3: Search Product
    static void searchProduct() {

        System.out.println("\n---------- SEARCH PRODUCT ----------");

        int id = readPositiveInt("Enter Product ID: ");

        if (inventory.containsKey(id)) {

            System.out.println("Product Found!");

            System.out.println("Product ID: " + id);

            System.out.println("Product Name: " + productNames.get(id));

            System.out.println("Category: " + productCategories.get(id));

            System.out.println("Price: " + productPrices.get(id));

            System.out.println("Available Quantity: " + inventory.get(id));

        } else {

            System.out.println("Product Not Found!");
        }
    }


    // Module 4: Update Product Quantity
    static void updateQuantity() {

        System.out.println("\n---------- UPDATE QUANTITY ----------");

        int id = readPositiveInt("Enter Product ID: ");

        if (!inventory.containsKey(id)) {

            System.out.println("Product Not Found!");
            return;
        }

        int quantity = readPositiveInt("Enter New Stock Quantity: ");

        int oldQuantity = inventory.get(id);

        inventory.put(id, oldQuantity + quantity);

        System.out.println("Stock Updated Successfully!");

        System.out.println("Product: " + productNames.get(id));

        System.out.println("Available Quantity: " + inventory.get(id));
    }


    // Module 5: Sell Product
    static void sellProduct() {

        System.out.println("\n---------- SELL PRODUCT ----------");

        int id = readPositiveInt("Enter Product ID: ");

        if (!inventory.containsKey(id)) {

            System.out.println("Product Not Found!");
            return;
        }

        int quantitySold = readPositiveInt("Enter Quantity Sold: ");

        int available = inventory.get(id);

        if (quantitySold <= available) {

            int remaining = available - quantitySold;

            inventory.put(id, remaining);

            System.out.println("Sale Completed Successfully!");

            System.out.println("Product ID: " + id);

            System.out.println("Product Name: " + productNames.get(id));

            System.out.println("Remaining Quantity: " + remaining);

        } else {

            System.out.println("Insufficient Stock!");

            System.out.println("Available Quantity: " + available);
        }
    }


    // Module 6: Remove Product
    static void removeProduct() {

        System.out.println("\n---------- REMOVE PRODUCT ----------");

        int id = readPositiveInt("Enter Product ID: ");

        if (inventory.containsKey(id)) {

            String name = productNames.get(id);

            String category = productCategories.get(id);

            inventory.remove(id);

            productNames.remove(id);

            productCategories.remove(id);

            productPrices.remove(id);

            recentProducts.remove(name);

            // Remove category only if no other product uses it
            if (!productCategories.containsValue(category)) {

                hash.remove(category);
            }

            System.out.println("Product Removed Successfully!");

        } else {

            System.out.println("Product Not Found!");
        }
    }


    // Module 7: Add Product Category
    static void addCategory() {

        System.out.println("\n---------- ADD CATEGORY ----------");

        String category = readString("Enter Category Name: ");

        if (hash.add(category)) {

            System.out.println("Category Added Successfully!");

        } else {

            System.out.println("Category Already Exists!");
        }
    }


    // Module 8: Display Unique Categories
    static void displayCategories() {

        System.out.println("\n---------- PRODUCT CATEGORIES ----------");

        if (hash.isEmpty()) {

            System.out.println("No Categories Found!");
            return;
        }

        for (String category : hash) {

            System.out.println(category);
        }

        System.out.println("\nTotal Unique Categories: " +hash.size());
    }


    // Module 9: Display Sorted Categories
    static void displaySortedCategories() {

        System.out.println("\n---------- SORTED CATEGORIES ----------");

        if (hash.isEmpty()) {

            System.out.println("No Categories Found!");
            return;
        }

        sortedCategories.clear();

        sortedCategories.addAll(hash);

        System.out.println("Alphabetical Order:");

        System.out.println(sortedCategories);

        System.out.println("First Category: " + sortedCategories.first());

        System.out.println("Last Category: " + sortedCategories.last());

        System.out.println("Descending Order:");

        System.out.println(sortedCategories.descendingSet());
    }


    // Module 10: Display Recently Added Products
    static void displayRecentProducts() {

        System.out.println("\n---------- RECENTLY ADDED PRODUCTS ----------");

        if (recentProducts.isEmpty()) {

            System.out.println("No Products Found!");
            return;
        }

        for (String name : recentProducts) {

            System.out.println(name);
        }

        System.out.println("\nTotal Products: " + recentProducts.size());
    }


    // Module 11: Generate Inventory Report
    static void generateReport() {

        System.out.println("\n---------- INVENTORY REPORT ----------");

        if (inventory.isEmpty()) {

            System.out.println("No Product Records Found!");
            return;
        }

        // Display All Products
        displayProducts();


        // Products With Quantity Below 5
        System.out.println("\nProducts With Quantity Below 5:");

        boolean found = false;

        for (int id : inventory.keySet()) {

            if (inventory.get(id) < 5) {

                System.out.println(
                        productNames.get(id) +
                        " - Quantity: " + inventory.get(id));

                found = true;
            }
        }

        if (!found) {

            System.out.println("No Low Stock Products!");
        }


        // Calculate Total Available Units
        int totalUnits = 0;

        for (int quantity : inventory.values()) {

            totalUnits += quantity;
        }

        System.out.println("\nTotal Available Units: " + totalUnits);


        // Find Highest Available Quantity
        int highest = Collections.max(inventory.values());

        System.out.println("\nHighest Available Quantity: " + highest);

        for (int id : inventory.keySet()) {

            if (inventory.get(id) == highest) {

                System.out.println("Product: " + productNames.get(id));
            }
        }


        // Display Unique Categories
        System.out.println("\nUnique Categories:");

        displayCategories();
    }
}