
import java.sql.*;
import java.util.Scanner;

public class OrderManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/library_db";
        String username = "root";
        String password = "Admin@123";

        try {
            Connection con = DriverManager.getConnection(
                url, username, password
            );

            System.out.println("Database Connected Successfully!");

            while (true) {

                System.out.println("\n1. Insert New Order");
                System.out.println("2. Display All Orders");
                System.out.println("3. Search Order By ID");
                System.out.println("4. Display Customer Orders");
                System.out.println("5. Update Order Status");
                System.out.println("6. Display Pending Orders");
                System.out.println("7. Delete Cancelled Order");
                System.out.println("8. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:

                        String insert =
                            "INSERT INTO orders VALUES (?, ?, ?, ?, ?, ?)";

                        PreparedStatement ps1 =
                            con.prepareStatement(insert);

                        System.out.print("Enter Order ID: ");
                        ps1.setInt(1, sc.nextInt());

                        sc.nextLine();

                        System.out.print("Enter Customer Name: ");
                        ps1.setString(2, sc.nextLine());

                        System.out.print("Enter Product Name: ");
                        ps1.setString(3, sc.nextLine());

                        System.out.print("Enter Quantity: ");
                        ps1.setInt(4, sc.nextInt());

                        System.out.print("Enter Total Amount: ");
                        ps1.setDouble(5, sc.nextDouble());

                        sc.nextLine();

                        System.out.print("Enter Order Status: ");
                        ps1.setString(6, sc.nextLine());

                        int inserted = ps1.executeUpdate();

                        System.out.println(inserted + " Order Inserted!");

                        ps1.close();
                        break;


                    // DISPLAY ALL ORDERS
                    case 2:

                        Statement st = con.createStatement();

                        ResultSet rs = st.executeQuery(
                            "SELECT * FROM orders"
                        );

                        while (rs.next()) {

                            System.out.println(
                                rs.getInt("order_id") + " " +
                                rs.getString("customer_name") + " " +
                                rs.getString("product_name") + " " +
                                rs.getInt("quantity") + " " +
                                rs.getDouble("total_amount") + " " +
                                rs.getString("order_status")
                            );
                        }

                        rs.close();
                        st.close();
                        break;


                    // SEARCH ORDER BY ID
                    case 3:

                        System.out.print("Enter Order ID: ");
                        int id = sc.nextInt();

                        PreparedStatement ps2 = con.prepareStatement(
                            "SELECT * FROM orders WHERE order_id = ?"
                        );

                        ps2.setInt(1, id);

                        ResultSet rs2 = ps2.executeQuery();

                        if (rs2.next()) {

                            System.out.println(
                                "Customer: " +
                                rs2.getString("customer_name")
                            );

                            System.out.println(
                                "Product: " +
                                rs2.getString("product_name")
                            );

                            System.out.println(
                                "Amount: " +
                                rs2.getDouble("total_amount")
                            );

                            System.out.println(
                                "Status: " +
                                rs2.getString("order_status")
                            );

                        } else {
                            System.out.println("Order Not Found!");
                        }

                        rs2.close();
                        ps2.close();
                        break;
                    case 4:

                        sc.nextLine();

                        System.out.print("Enter Customer Name: ");
                        String name = sc.nextLine();

                        PreparedStatement ps3 = con.prepareStatement(
                            "SELECT * FROM orders WHERE customer_name = ?"
                        );

                        ps3.setString(1, name);

                        ResultSet rs3 = ps3.executeQuery();

                        while (rs3.next()) {

                            System.out.println(
                                rs3.getInt("order_id") + " " +
                                rs3.getString("product_name") + " " +
                                rs3.getDouble("total_amount") + " " +
                                rs3.getString("order_status")
                            );
                        }

                        rs3.close();
                        ps3.close();
                        break;

                    case 5:

                        System.out.print("Enter Order ID: ");
                        int updateId = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter New Order Status: ");
                        String status = sc.nextLine();

                        PreparedStatement ps4 = con.prepareStatement(
                            "UPDATE orders SET order_status = ? WHERE order_id = ?"
                        );

                        ps4.setString(1, status);
                        ps4.setInt(2, updateId);

                        int updated = ps4.executeUpdate();

                        System.out.println(updated + " Order Updated!");

                        ps4.close();
                        break;

                    case 6:

                        Statement st2 = con.createStatement();

                        ResultSet rs4 = st2.executeQuery(
                            "SELECT * FROM orders WHERE order_status = 'Pending'"
                        );

                        while (rs4.next()) {

                            System.out.println(
                                rs4.getInt("order_id") + " " +
                                rs4.getString("customer_name") + " " +
                                rs4.getString("product_name")
                            );
                        }

                        rs4.close();
                        st2.close();
                        break;
                    case 7:

                        System.out.print("Enter Order ID: ");
                        int deleteId = sc.nextInt();

                        PreparedStatement ps5 = con.prepareStatement(
                            "DELETE FROM orders WHERE order_id = ? AND order_status = 'Cancelled'"
                        );

                        ps5.setInt(1, deleteId);

                        int deleted = ps5.executeUpdate();

                        if (deleted > 0) {
                            System.out.println("Cancelled Order Deleted!");
                        } else {
                            System.out.println(
                                "Order Not Found or Order is Not Cancelled!"
                            );
                        }

                        ps5.close();
                        break;
                    case 8:

                        con.close();
                        sc.close();

                        System.out.println("Program Terminated!");
                        return;


                    default:
                        System.out.println("Invalid Choice!");
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}