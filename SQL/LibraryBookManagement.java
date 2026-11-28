
import java.sql.*;
import java.util.Scanner;

public class LibraryBookManagement {

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

            int choice;

            do {

                System.out.println("1. Add New Book");
                System.out.println("2. Display All Books");
                System.out.println("3. Search Book Using ID");
                System.out.println("4. Search Books Using Author");
                System.out.println("5. Display Books By Category");
                System.out.println("6. Update Available Copies");
                System.out.println("7. Display Books With Zero Copies");
                System.out.println("8. Exit");

                System.out.print("Enter Your Choice: ");
                choice = sc.nextInt();

                switch (choice) {

                    // 1. Add New Books
                    case 1:

                        System.out.print("Enter Book ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Book Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Author Name: ");
                        String author = sc.nextLine();

                        System.out.print("Enter Category: ");
                        String category = sc.nextLine();

                        System.out.print("Enter Available Copies: ");
                        int copies = sc.nextInt();

                        if (copies < 0) {
                            System.out.println("Copies cannot be negative!");
                            break;
                        }

                        String insertQuery =
                            "INSERT INTO books VALUES (?, ?, ?, ?, ?)";

                        PreparedStatement ps =
                            con.prepareStatement(insertQuery);

                        ps.setInt(1, id);
                        ps.setString(2, name);
                        ps.setString(3, author);
                        ps.setString(4, category);
                        ps.setInt(5, copies);

                        int rows = ps.executeUpdate();

                        if (rows > 0) {
                            System.out.println("Book Added Successfully!");
                        }

                        ps.close();

                        break;

                    // 2. Display All Books
                    case 2:

                        String selectQuery = "SELECT * FROM books";

                        Statement st = con.createStatement();

                        ResultSet rs = st.executeQuery(selectQuery);

                        System.out.println("\nAll Book Details:");

                        while (rs.next()) {

                            System.out.println(
                                rs.getInt("book_id") + " " +
                                rs.getString("book_name") + " " +
                                rs.getString("author") + " " +
                                rs.getString("category") + " " +
                                rs.getInt("available_copies")
                            );
                        }

                        rs.close();
                        st.close();

                        break;

                    // 3. Search Book Using ID
                    case 3:

                        System.out.print("Enter Book ID: ");
                        int searchId = sc.nextInt();

                        String searchQuery =
                            "SELECT * FROM books WHERE book_id = ?";

                        PreparedStatement ps2 =
                            con.prepareStatement(searchQuery);

                        ps2.setInt(1, searchId);

                        ResultSet rs2 = ps2.executeQuery();

                        if (rs2.next()) {

                            System.out.println("\nBook Found!");

                            System.out.println("Book ID: " +
                                rs2.getInt("book_id"));

                            System.out.println("Book Name: " +
                                rs2.getString("book_name"));

                            System.out.println("Author: " +
                                rs2.getString("author"));

                            System.out.println("Category: " +
                                rs2.getString("category"));

                            System.out.println("Available Copies: " +
                                rs2.getInt("available_copies"));

                        } else {

                            System.out.println("Book ID Does Not Exist!");

                        }

                        rs2.close();
                        ps2.close();

                        break;

                    // 4. Search Books Using Author Name
                    case 4:

                        sc.nextLine();

                        System.out.print("Enter Author Name: ");
                        String searchAuthor = sc.nextLine();

                        String authorQuery =
                            "SELECT * FROM books WHERE author LIKE ?";

                        PreparedStatement ps3 =
                            con.prepareStatement(authorQuery);

                        ps3.setString(1, "%" + searchAuthor + "%");

                        ResultSet rs3 = ps3.executeQuery();

                        boolean found = false;

                        while (rs3.next()) {

                            found = true;

                            System.out.println(
                                rs3.getInt("book_id") + " " +
                                rs3.getString("book_name") + " " +
                                rs3.getString("author") + " " +
                                rs3.getString("category") + " " +
                                rs3.getInt("available_copies")
                            );
                        }

                        if (!found) {
                            System.out.println("No Books Found!");
                        }

                        rs3.close();
                        ps3.close();

                        break;

                    // 5. Display Books By Category
                    case 5:

                        sc.nextLine();

                        System.out.print("Enter Category: ");
                        String searchCategory = sc.nextLine();

                        String categoryQuery =
                            "SELECT * FROM books WHERE category = ?";

                        PreparedStatement ps4 =
                            con.prepareStatement(categoryQuery);

                        ps4.setString(1, searchCategory);

                        ResultSet rs4 = ps4.executeQuery();

                        boolean categoryFound = false;

                        while (rs4.next()) {

                            categoryFound = true;

                            System.out.println(
                                rs4.getInt("book_id") + " " +
                                rs4.getString("book_name") + " " +
                                rs4.getString("author") + " " +
                                rs4.getString("category") + " " +
                                rs4.getInt("available_copies")
                            );
                        }

                        if (!categoryFound) {
                            System.out.println("No Books Found In This Category!");
                        }

                        rs4.close();
                        ps4.close();

                        break;

                    // 6. Update Available Copies
                    case 6:

                        System.out.print("Enter Book ID: ");
                        int updateId = sc.nextInt();

                        System.out.print("Enter New Available Copies: ");
                        int newCopies = sc.nextInt();

                        if (newCopies < 0) {
                            System.out.println("Copies cannot be negative!");
                            break;
                        }

                        String updateQuery =
                            "UPDATE books SET available_copies = ? " +
                            "WHERE book_id = ?";

                        PreparedStatement ps5 =
                            con.prepareStatement(updateQuery);

                        ps5.setInt(1, newCopies);
                        ps5.setInt(2, updateId);

                        int updateRows = ps5.executeUpdate();

                        if (updateRows > 0) {

                            System.out.println("Copies Updated Successfully!");

                        } else {

                            System.out.println("Book ID Does Not Exist!");

                        }

                        ps5.close();

                        break;

                    // 7. Display Books With Zero Available Copies
                    case 7:

                        String zeroQuery =
                            "SELECT * FROM books WHERE available_copies = 0";

                        Statement st2 = con.createStatement();

                        ResultSet rs5 = st2.executeQuery(zeroQuery);

                        System.out.println("\nBooks With Zero Available Copies:");

                        boolean zeroFound = false;

                        while (rs5.next()) {

                            zeroFound = true;

                            System.out.println(
                                rs5.getInt("book_id") + " " +
                                rs5.getString("book_name") + " " +
                                rs5.getString("author") + " " +
                                rs5.getString("category") + " " +
                                rs5.getInt("available_copies")
                            );
                        }

                        if (!zeroFound) {
                            System.out.println("No Books With Zero Copies!");
                        }

                        rs5.close();
                        st2.close();

                        break;

                    // 8. Exit
                    case 8:

                        System.out.println("Thank You For Using Library Management System!");

                        break;

                    default:

                        System.out.println("Invalid Choice!");

                }

            } while (choice != 8);

            // Close database connection
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        sc.close();
    }
}

