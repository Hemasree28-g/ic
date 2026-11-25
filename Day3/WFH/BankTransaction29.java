public class BankTransaction29 {
    int balance = 10000;
    public void withdraw(String amount) {
        try {
            int withdrawAmount = Integer.parseInt(amount);

            if (withdrawAmount <= 0) {
                throw new IllegalArgumentException("Invalid withdrawal amount");
            }

            if (withdrawAmount > balance) {
                throw new IllegalArgumentException("Insufficient balance");
            }
            balance = balance - withdrawAmount;
            System.out.println("successful");
            System.out.println("Remaining Balance: " + balance);
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid amount format");
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        BankTransaction29 obj = new BankTransaction29();

        obj.withdraw("2000");
        obj.withdraw("15000");
        obj.withdraw("abc");
        obj.withdraw("-500");
        obj.withdraw("0");
    }
}
