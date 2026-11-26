import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library();
        int choice;

        do {
           
            System.out.println("          LIBRARY MANAGEMENT SYSTEM");
     
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Register Student");
            System.out.println("5. Register Faculty");
            System.out.println("6. Display All Members");
            System.out.println("7. Search Member");
            System.out.println("8. Issue Book");
            System.out.println("9. Return Book");
            System.out.println("10. Display Issued Books");
            System.out.println("11. Generate Library Report");
            System.out.println("12. Exit");

            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addBook(library);
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    library.searchBook(readInt("Enter Book ID: "));
                    break;
                case 4:
                    registerStudent(library);
                    break;
                case 5:
                    registerFaculty(library);
                    break;
                case 6:
                    library.displayMembers();
                    break;
                case 7:
                    library.searchMember(readInt("Enter Member ID: "));
                    break;
                case 8:
                    library.issueBook(readInt("Enter Book ID: "),
                                      readInt("Enter Member ID: "));
                    break;
                case 9:
                    library.returnBook(readInt("Enter Book ID: "),
                                       readInt("Enter Member ID: "));
                    break;
                case 10:
                    System.out.print("Show only active issues? (yes/no): ");
                    String answer = sc.nextLine().trim();
                    library.displayIssuedBooks(answer.equalsIgnoreCase("yes"));
                    break;
                case 11:
                    library.generateReport();
                    break;
                case 12:
                    System.out.println("Thank you for using the Library Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 12);

        sc.close();
    }

    private static void addBook(Library library) {
        int id = readInt("Enter Book ID: ");
        System.out.print("Enter Book Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();
        System.out.print("Enter Category: ");
        String category = sc.nextLine();
        int copies = readInt("Enter Available Copies: ");

        if (id <= 0 || copies < 0 || name.trim().isEmpty()
                || author.trim().isEmpty() || category.trim().isEmpty()) {
            System.out.println("Invalid input. ID must be positive, copies cannot be negative, and text fields cannot be empty.");
            return;
        }

        library.addBook(new Book(id, name, author, category, copies));
    }

    private static void registerStudent(Library library) {
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = sc.nextLine();
        System.out.print("Enter Department: ");
        String department = sc.nextLine();
        int year = readInt("Enter Year: ");

        if (name.trim().isEmpty() || contact.trim().isEmpty()
                || department.trim().isEmpty() || year <= 0) {
            System.out.println("Invalid student details.");
            return;
        }
        library.registerStudent(name, contact, department, year);
    }

    private static void registerFaculty(Library library) {
        System.out.print("Enter Faculty Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = sc.nextLine();
        System.out.print("Enter Department: ");
        String department = sc.nextLine();
        System.out.print("Enter Designation: ");
        String designation = sc.nextLine();

        if (name.trim().isEmpty() || contact.trim().isEmpty()
                || department.trim().isEmpty() || designation.trim().isEmpty()) {
            System.out.println("Invalid faculty details.");
            return;
        }
        library.registerFaculty(name, contact, department, designation);
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
}
