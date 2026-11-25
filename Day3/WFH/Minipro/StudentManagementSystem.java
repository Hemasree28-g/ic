import java.util.*; 
class Student {

    // Encapsulation - Private Variables
    private int studentId;
    private String name;
    private String department;
    private int marks[] = new int[3];
    private boolean marksEntered = false;
    Student(int studentId, String name, String department) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
    }
    public void enterMarks(Scanner sc) {
        for (int i = 0; i < 3; i++) {
            while (true) {
                System.out.print("Enter Subject " + (i + 1) + " Marks: ");
                int mark = sc.nextInt();

                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    break;
                } else {
                    System.out.println("Invalid marks! Enter between 0 and 100.");
                }
            }
        }
        marksEntered = true;
        System.out.println("Marks entered successfully!");
    }
    // Check
    public boolean hasMarks() {
        return marksEntered;
    }
    public void displayStudent() {
        System.out.println("\n STUDENT DETAILS ");
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
    }
    public int calculateTotal() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }
    public double calculateAverage() {
        return calculateTotal() / 3.0;
    }

    public String calculateGrade() {
        double average = calculateAverage();
        if (average >= 90)
            return "A+";
        else if (average >= 80)
            return "A";
        else if (average >= 70)
            return "B";
        else if (average >= 60)
            return "C";
        else if (average >= 50)
            return "D";
        else
            return "Fail";
    }
    public String checkResult() {
        if (calculateAverage() >= 50)
            return "PASS";
        else
            return "FAIL";
    }
    public void displayReport() {
        if (!marksEntered) {
            System.out.println("Please enter marks first!");
            return;
        }

        System.out.println("\n STUDENT REPORT ");

        System.out.println("Student ID   : " + studentId);
        System.out.println("Name         : " + name);
        System.out.println("Department   : " + department);

        for (int i = 0; i < 3; i++) {
            System.out.println("Subject " + (i + 1) +
                               " Marks : " + marks[i]);
        }

        System.out.println("Total Marks  : " + calculateTotal());
        System.out.println("Average      : " + calculateAverage());
        System.out.println("Grade        : " + calculateGrade());
        System.out.println("Result       : " + checkResult());
    }
}
public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Student student = null;

        int choice;

        System.out.println("STUDENT MANAGEMENT SYSTEM");

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Student");
            System.out.println("3. Enter Marks");
            System.out.println("4. Calculate Total");
            System.out.println("5. Calculate Average");
            System.out.println("6. Calculate Grade");
            System.out.println("7. Pass/Fail");
            System.out.println("8. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    student = new Student(id, name, department);

                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (student != null) {
                        student.displayStudent();
                    } else {
                        System.out.println("Please add student first!");
                    }
                    break;

                case 3:
                    if (student != null) {
                        student.enterMarks(sc);
                    } else {
                        System.out.println("Please add student first!");
                    }
                    break;

                case 4:
                    if (student != null && student.hasMarks()) {
                        System.out.println("Total Marks: " +
                                           student.calculateTotal());
                    } else {
                        System.out.println("Please add student and enter marks first!");
                    }
                    break;

                case 5:
                    if (student != null && student.hasMarks()) {
                        System.out.println("Average Marks: " +
                                           student.calculateAverage());
                    } else {
                        System.out.println("Please enter marks first!");
                    }
                    break;

                case 6:
                    if (student != null && student.hasMarks()) {
                        System.out.println("Grade: " +
                                           student.calculateGrade());
                    } else {
                        System.out.println("Please enter marks first!");
                    }
                    break;

                case 7:
                    if (student != null && student.hasMarks()) {
                        System.out.println("Result: " +
                                           student.checkResult());
                    } else {
                        System.out.println("Please enter marks first!");
                    }
                    break;

                case 8:
                    System.out.println("Thank you! Exiting application...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 8);

    }
}
