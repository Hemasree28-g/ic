class BankAccount {
    private String accountHolder = "A";
    private double balance = 1000;

    public void getAccountHolder() {
        System.out.println(accountHolder);
    }
    public void getBalance() {
        System.out.println( balance);
    }
    public void setAccountHolder(String name) {
        accountHolder = name;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
        } else {
            balance = balance + amount;
            System.out.println("Amount deposited successfully");
        }
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
        } else if (amount > balance) {
            System.out.println("no balance");
        } else {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully");
        }
    }
}
public class Valid {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        b.getAccountHolder();
        b.getBalance();
        b.deposit(500);
        b.getBalance();
        b.withdraw(200);
        b.getBalance();
        b.withdraw(2000);
        b.getBalance();
    }
}