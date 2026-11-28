
import java.sql.*;
import java.util.Scanner;

public class BankAccountManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/bank_db";
        String username = "root";
        String password = "Admin@123";

        try {

            Connection con = DriverManager.getConnection(
                url, username, password
            );

            System.out.println("Database Connected Successfully!");

            int choice;

            do {
                System.out.println("\n===== BANK ACCOUNT MANAGEMENT =====");
                System.out.println("1. Create Bank Account");
                System.out.println("2. Display All Accounts");
                System.out.println("3. Search Account");
                System.out.println("4. Deposit Money");
                System.out.println("5. Withdraw Money");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:

                        System.out.print("Enter Account ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Customer Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Account Type: ");
                        String type = sc.nextLine();

                        System.out.print("Enter Initial Balance: ");
                        double balance = sc.nextDouble();

                        if (balance < 0) {
                            System.out.println("Balance cannot be negative!");
                            break;
                        }

                        String insertQuery =
                            "INSERT INTO bank_accounts VALUES (?, ?, ?, ?)";

                        PreparedStatement ps =
                            con.prepareStatement(insertQuery);

                        ps.setInt(1, id);
                        ps.setString(2, name);
                        ps.setString(3, type);
                        ps.setDouble(4, balance);

                        int rows = ps.executeUpdate();

                        if (rows > 0) {
                            System.out.println("Account Created Successfully!");
                        }

                        ps.close();

                        break;
                    case 2:

                        String selectQuery =
                            "SELECT * FROM bank_accounts";

                        Statement st = con.createStatement();

                        ResultSet rs = st.executeQuery(selectQuery);

                        System.out.println("\nBank Account Details:");

                        while (rs.next()) {

                            System.out.println(
                                rs.getInt("account_id") + " " +
                                rs.getString("customer_name") + " " +
                                rs.getString("account_type") + " " +
                                rs.getDouble("balance")
                            );
                        }

                        rs.close();
                        st.close();

                        break;

                    case 3:

                        System.out.print("Enter Account ID: ");
                        int searchId = sc.nextInt();

                        String searchQuery =
                            "SELECT * FROM bank_accounts WHERE account_id = ?";

                        PreparedStatement ps2 =
                            con.prepareStatement(searchQuery);

                        ps2.setInt(1, searchId);

                        ResultSet rs2 = ps2.executeQuery();

                        if (rs2.next()) {

                            System.out.println("\nAccount Found!");

                            System.out.println("Account ID: " +
                                rs2.getInt("account_id"));

                            System.out.println("Customer Name: " +
                                rs2.getString("customer_name"));

                            System.out.println("Account Type: " +
                                rs2.getString("account_type"));

                            System.out.println("Balance: " +
                                rs2.getDouble("balance"));

                        } else {

                            System.out.println("Account ID does not exist!");

                        }

                        rs2.close();
                        ps2.close();

                        break;

                    // 4. Deposit Money
                    case 4:

                        System.out.print("Enter Account ID: ");
                        int depositId = sc.nextInt();

                        System.out.print("Enter Deposit Amount: ");
                        double deposit = sc.nextDouble();

                        if (deposit <= 0) {
                            System.out.println("Enter a valid deposit amount!");
                            break;
                        }

                        String depositQuery =
                            "UPDATE bank_accounts SET balance = balance + ? " +
                            "WHERE account_id = ?";

                        PreparedStatement ps3 =
                            con.prepareStatement(depositQuery);

                        ps3.setDouble(1, deposit);
                        ps3.setInt(2, depositId);

                        int depositRows = ps3.executeUpdate();

                        if (depositRows > 0) {

                            System.out.println("Amount Deposited Successfully!");

                            displayBalance(con, depositId);

                        } else {

                            System.out.println("Account ID does not exist!");

                        }

                        ps3.close();

                        break;
                    case 5:

                        System.out.print("Enter Account ID: ");
                        int withdrawId = sc.nextInt();

                        System.out.print("Enter Withdrawal Amount: ");
                        double withdraw = sc.nextDouble();

                        if (withdraw <= 0) {
                            System.out.println("Enter a valid withdrawal amount!");
                            break;
                        }

                        String withdrawQuery =
                            "UPDATE bank_accounts SET balance = balance - ? " +
                            "WHERE account_id = ? AND balance >= ?";

                        PreparedStatement ps4 =
                            con.prepareStatement(withdrawQuery);

                        ps4.setDouble(1, withdraw);
                        ps4.setInt(2, withdrawId);
                        ps4.setDouble(3, withdraw);

                        int withdrawRows = ps4.executeUpdate();

                        if (withdrawRows > 0) {

                            System.out.println("Amount Withdrawn Successfully!");

                            displayBalance(con, withdrawId);

                        } else {

                            String checkQuery =
                                "SELECT balance FROM bank_accounts " +
                                "WHERE account_id = ?";

                            PreparedStatement ps5 =
                                con.prepareStatement(checkQuery);

                            ps5.setInt(1, withdrawId);

                            ResultSet rs5 = ps5.executeQuery();

                            if (rs5.next()) {

                                System.out.println(
                                    "Insufficient Balance! Available Balance: " +
                                    rs5.getDouble("balance")
                                );

                            } else {

                                System.out.println("Account ID does not exist!");

                            }

                            rs5.close();
                            ps5.close();

                        }

                        ps4.close();

                        break;

                    // 6. Exit
                    case 6:

                        System.out.println("Thank You for Using Our Bank!");

                        break;

                    default:

                        System.out.println("Invalid Choice!");

                }

            } while (choice != 6);

            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        sc.close();
    }

    // Method to display updated account balance
    public static void displayBalance(Connection con, int id)
            throws SQLException {

        String query =
            "SELECT * FROM bank_accounts WHERE account_id = ?";

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            System.out.println("\nUpdated Account Details:");

            System.out.println("Account ID: " +
                rs.getInt("account_id"));

            System.out.println("Customer Name: " +
                rs.getString("customer_name"));

            System.out.println("Account Type: " +
                rs.getString("account_type"));

            System.out.println("Updated Balance: " +
                rs.getDouble("balance"));
        }

        rs.close();
        ps.close();
    }
}