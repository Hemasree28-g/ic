import java.sql.*;
import java.util.Scanner;
public class Customer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/shopping_company";
        String username = "root";
        String password = "Admin@123";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database connected successfully!");

            System.out.println("Enter Customer ID:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Customer Name:");
            String name = sc.nextLine();

            System.out.println("Enter Email:");
            String email = sc.nextLine();

            System.out.println("Enter Phone:");
            String phone = sc.nextLine();

            System.out.println("Enter City:");
            String city = sc.nextLine();

            String insertQuery = "INSERT INTO customers VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, city);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Customer registered successfully!");
            }

            String selectQuery = "SELECT * FROM customers";
            PreparedStatement ps1 = con.prepareStatement(selectQuery);

            ResultSet rs = ps1.executeQuery();
            System.out.println("\n--- All Customers ---");

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.println("Customer ID: " + rs.getInt("customer_id"));
                System.out.println("Customer Name: " + rs.getString("customer_name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("City: " + rs.getString("city"));

                System.out.println("----------------------");
            }

            if (!found) {
                System.out.println("No customers found!");
            }

            // 3. Search Customer Using Customer ID

            System.out.println("\nEnter Customer ID to Search:");
            int searchId = sc.nextInt();
            sc.nextLine();

            String searchQuery = "SELECT * FROM customers WHERE customer_id = ?";

            PreparedStatement ps2 = con.prepareStatement(searchQuery);

            ps2.setInt(1, searchId);

            ResultSet rs1 = ps2.executeQuery();

            if (rs1.next()) {

                System.out.println("\nCustomer Found!");

                System.out.println("Customer ID: " + rs1.getInt("customer_id"));
                System.out.println("Customer Name: " + rs1.getString("customer_name"));
                System.out.println("Email: " + rs1.getString("email"));
                System.out.println("Phone: " + rs1.getString("phone"));
                System.out.println("City: " + rs1.getString("city"));

            } else {

                System.out.println("Customer not found!");
            }

            // 4. Search Customer Using Phone Number

            System.out.println("\nEnter Phone Number to Search:");
            String searchPhone = sc.nextLine();

            String phoneQuery = "SELECT * FROM customers WHERE phone = ?";

            PreparedStatement ps3 = con.prepareStatement(phoneQuery);

            ps3.setString(1, searchPhone);

            ResultSet rs2 = ps3.executeQuery();

            if (rs2.next()) {

                System.out.println("\nCustomer Found!");

                System.out.println("Customer ID: " + rs2.getInt("customer_id"));
                System.out.println("Customer Name: " + rs2.getString("customer_name"));
                System.out.println("Email: " + rs2.getString("email"));
                System.out.println("Phone: " + rs2.getString("phone"));
                System.out.println("City: " + rs2.getString("city"));

            } else {

                System.out.println("Customer not found!");
            }

            // 5. Display Customers From Particular City

            System.out.println("\nEnter City to Search:");
            String searchCity = sc.nextLine();

            String cityQuery = "SELECT * FROM customers WHERE city = ?";

            PreparedStatement ps4 = con.prepareStatement(cityQuery);

            ps4.setString(1, searchCity);

            ResultSet rs3 = ps4.executeQuery();

            System.out.println("\n--- Customers from " + searchCity + " ---");

            boolean cityFound = false;

            while (rs3.next()) {

                cityFound = true;

                System.out.println("Customer ID: " + rs3.getInt("customer_id"));
                System.out.println("Customer Name: " + rs3.getString("customer_name"));
                System.out.println("Email: " + rs3.getString("email"));
                System.out.println("Phone: " + rs3.getString("phone"));

                System.out.println("----------------------");
            }

            if (!cityFound) {
                System.out.println("No customers found in this city!");
            }

            // Close Resources

            rs.close();
            rs1.close();
            rs2.close();
            rs3.close();

            ps.close();
            ps1.close();
            ps2.close();
            ps3.close();
            ps4.close();

            con.close();

        } catch (SQLException e) {

            System.out.println(e);

        }

        sc.close();
    }
}
