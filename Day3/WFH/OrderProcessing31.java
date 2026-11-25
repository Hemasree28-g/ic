import java.util.Scanner;

public class OrderProcessing31 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String productName = "Laptop";
        String quantity = "2";
        double[] productPrices = {45000, 55000, 65000};

        try {
            System.out.println("Enter quantity:");
            quantity = sc.nextLine();

            int qty = Integer.parseInt(quantity);
            System.out.println("Enter product position (0-2):");
            int position = sc.nextInt();
            double productPrice = productPrices[position];
            double totalPrice = qty * productPrice;

            System.out.println("Product Name: " + productName);
            System.out.println("Product Price: " + productPrice);
            System.out.println("Total Price: " + totalPrice);
        }

        catch (NumberFormatException e) {
            System.out.println("Invalid quantity format");
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid product position");
        }

        finally {
            System.out.println("Order Processing Completed");
        }
    }
}
