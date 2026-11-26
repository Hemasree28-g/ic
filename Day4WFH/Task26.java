import java.util.HashMap;
import java.util.Map;

public class Task26 {
    public static void main(String[] args) {

        HashMap<Integer, Double> accounts = new HashMap<>();

        accounts.put(101, 5000.0);
        accounts.put(102, 10000.0);
        accounts.put(103, 15000.0);

        System.out.println("Bank Accounts: " + accounts);

        int depositAccount = 101;
        double depositAmount = 2000.0;

        if (accounts.containsKey(depositAccount)) {
            double balance = accounts.get(depositAccount);
            accounts.put(depositAccount, balance + depositAmount);
            System.out.println("After Deposit: " + accounts.get(depositAccount));
        } else {
            System.out.println("Account Not Found");
        }

        int withdrawAccount = 102;
        double withdrawAmount = 3000.0;

        if (accounts.containsKey(withdrawAccount)) {
            double balance = accounts.get(withdrawAccount);

            if (balance >= withdrawAmount) {
                accounts.put(withdrawAccount, balance - withdrawAmount);
                System.out.println("After Withdrawal: " + accounts.get(withdrawAccount));
            } else {
                System.out.println("Insufficient Balance");
            }
        } else {
            System.out.println("Account Not Found");
        }

        int accountNumber = 103;

        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account Balance: " + accounts.get(accountNumber));
        } else {
            System.out.println("Account Not Found");
        }


        int checkAccount = 105;

        if (accounts.containsKey(checkAccount)) {
            System.out.println("Balance: " + accounts.get(checkAccount));
        } else {
            System.out.println("Account 105 Not Found");
        }

   
        System.out.println("All Bank Accounts:");

        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            System.out.println("Account Number: " + entry.getKey()
                    + ", Balance: " + entry.getValue());
        }

        double totalBalance = 0;

        for (double balance : accounts.values()) {
            totalBalance = totalBalance + balance;
        }

        System.out.println("Total Bank Balance: " + totalBalance);
    }
}