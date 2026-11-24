abstract class Payment {
    double amount;
    Payment(double amount) {
        this.amount = amount;
    }
    void showAmount() {
        System.out.println("Payment Amount: "+amount);
    }
   abstract void processPayment();
}
class UPIPayment extends Payment {
    UPIPayment() {
        super(30000);
    }
    @Override
    void processPayment() {
        System.out.println("Payment processed successfully using UPI");
    }
}
public class Payment23 {
    public static void main(String[] args) {
        UPIPayment u = new UPIPayment();
        u.showAmount();
        u.processPayment();
    }
}