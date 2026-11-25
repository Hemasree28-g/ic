public class OnlinePayment25 {
    public static void main(String[] args) {

        String paymentAmount = "2500";

        try {
            double amount = Double.parseDouble(paymentAmount);
            System.out.println("Payment Amount: " + amount);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid payment amount");
        }

        paymentAmount = "1500.50";

        try {
            double amount = Double.parseDouble(paymentAmount);
            System.out.println("Payment Amount: " + amount);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid payment amount");
        }

        paymentAmount = "abc";

        try {
            double amount = Double.parseDouble(paymentAmount);
            System.out.println("Payment Amount: " + amount);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid payment amount");
        }

        paymentAmount = "25xyz";

        try {
            double amount = Double.parseDouble(paymentAmount);
            System.out.println("Payment Amount: " + amount);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid payment amount");
        }
    }
}
