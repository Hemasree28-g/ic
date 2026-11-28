import java.sql.*;
import java.util.Scanner;

public class Prodect  {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/retail_shop";
        String username = "root";
        String password = "Admin@123";

        try {

            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Database connected successfully!");

            System.out.println("\nEnter Product ID:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Product Name:");
            String name = sc.nextLine();

            System.out.println("Enter Category:");
            String category = sc.nextLine();

            System.out.println("Enter Price:");
            double price = sc.nextDouble();

            System.out.println("Enter Stock Quantity:");
            int quantity = sc.nextInt();
            sc.nextLine();

            String insertQuery = "INSERT INTO products VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(insertQuery);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, category);
            ps.setDouble(4, price);
            ps.setInt(5, quantity);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Product inserted successfully!");
            }

            String selectQuery = "SELECT * FROM products";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(selectQuery);

            System.out.println("\n--- All Products ---");

            while (rs.next()) {

                System.out.println("Product ID: " + rs.getInt("product_id"));
                System.out.println("Product Name: " + rs.getString("product_name"));
                System.out.println("Category: " + rs.getString("category"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("Stock Quantity: " + rs.getInt("stock_quantity"));

                System.out.println("----------------------");
            }


            System.out.println("\nEnter Product ID to Search:");
            int searchId = sc.nextInt();
            sc.nextLine();

            String searchQuery = "SELECT * FROM products WHERE product_id = ?";

            PreparedStatement ps1 = con.prepareStatement(searchQuery);

            ps1.setInt(1, searchId);

            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {

                System.out.println("\nProduct Found!");

                System.out.println("Product ID: " + rs1.getInt("product_id"));
                System.out.println("Product Name: " + rs1.getString("product_name"));
                System.out.println("Category: " + rs1.getString("category"));
                System.out.println("Price: " + rs1.getDouble("price"));
                System.out.println("Stock Quantity: " + rs1.getInt("stock_quantity"));

            } else {

                System.out.println("Product not found!");
            }

            // 4. Display Products by Category

            System.out.println("\nEnter Category:");
            String searchCategory = sc.nextLine();

            String categoryQuery = "SELECT * FROM products WHERE category = ?";

            PreparedStatement ps2 = con.prepareStatement(categoryQuery);

            ps2.setString(1, searchCategory);

            ResultSet rs2 = ps2.executeQuery();

            System.out.println("\n--- Products in " + searchCategory + " ---");

            while (rs2.next()) {

                System.out.println("Product ID: " + rs2.getInt("product_id"));
                System.out.println("Product Name: " + rs2.getString("product_name"));
                System.out.println("Price: " + rs2.getDouble("price"));
                System.out.println("Stock Quantity: " + rs2.getInt("stock_quantity"));

                System.out.println("----------------------");
            }
            String stockQuery = "SELECT * FROM products WHERE stock_quantity < 10";

            Statement st1 = con.createStatement();

            ResultSet rs3 = st1.executeQuery(stockQuery);

            System.out.println("\n--- Low Stock Products ---");

            while (rs3.next()) {

                System.out.println("Product ID: " + rs3.getInt("product_id"));
                System.out.println("Product Name: " + rs3.getString("product_name"));
                System.out.println("Stock Quantity: " + rs3.getInt("stock_quantity"));

                System.out.println("----------------------");
            }

            String countQuery = "SELECT COUNT(*) FROM products";

            Statement st2 = con.createStatement();

            ResultSet rs4 = st2.executeQuery(countQuery);

            if (rs4.next()) {

                System.out.println("\nTotal Number of Products: " + rs4.getInt(1));
            }

            rs.close();
            rs1.close();
            rs2.close();
            rs3.close();
            rs4.close();

            ps.close();
            ps1.close();
            ps2.close();

            st.close();
            st1.close();
            st2.close();

            con.close();

        } catch (SQLException e) {

            System.out.println(e);

        }

        sc.close();
    }
}