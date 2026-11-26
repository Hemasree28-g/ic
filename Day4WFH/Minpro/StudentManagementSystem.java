import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;
public class StudentManagementSystem {
    static Scanner sc = new Scanner(System.in);
    // ArrayLists to store student details
    static ArrayList<Integer> studentIds = new ArrayList<>();
    static ArrayList<String> studentNames = new ArrayList<>();
    static ArrayList<Integer> studentMarks = new ArrayList<>();

    static LinkedList<String> attendance = new LinkedList<>();
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("1. Add");
            System.out.println("2. Display");
            System.out.println("3. Search");
            System.out.println("4. Update");
            System.out.println("5. Remove");
            System.out.println("6. Add  Attendance");
            System.out.println("7. Display Attendance");
            System.out.println("8. Remove Attendance");
            System.out.println("9. Display Student Statistics");
            System.out.println("10. Sort Student Names");
            System.out.println("11. Exit");

            choice = readInt("\nEnter Your Choice: ");
            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    removeStudent();
                    break;

                case 6:
                    addAttendance();
                    break;

                case 7:
                    displayAttendance();
                    break;

                case 8:
                    removeAttendance();
                    break;

                case 9:
                    displayStatistics();
                    break;

                case 10:
                    sortStudents();
                    break;

                case 11:
                    System.out.println("Thank you");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 11);
        sc.close();
    }

    // Read
    static int readInt(String message) {

        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    // Validate 
    static int readMarks() {

        int marks;

        while (true) {

            marks = readInt("Enter Student Marks (0-100): ");

            if (marks >= 0 && marks <= 100) {
                return marks;
            }

            System.out.println("Invalid marks! Enter marks between 0 and 100.");
        }
    }

    static int findStudent(String name) {
        return studentNames.indexOf(name);
    }

    static void addStudent() {

        System.out.println("\n ADD STUDENT ");

        int id = readInt("Enter Student ID: ");

        if (studentIds.contains(id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Student name cannot be empty!");
            return;
        }

        int marks = readMarks();

        studentIds.add(id);
        studentNames.add(name);
        studentMarks.add(marks);

        System.out.println("Student Added Successfully!");
    }

    static void displayStudents() {

        System.out.println("\n STUDENT RECORDS");

        if (studentNames.isEmpty()) {
            System.out.println("No student records found!");
            return;
        }

        System.out.printf("%-12s %-20s %-10s%n",
                "Student ID", "Student Name", "Marks");

        for (int i = 0; i < studentNames.size(); i++) {

            System.out.printf("%-12d %-20s %-10d%n",
                    studentIds.get(i),
                    studentNames.get(i),
                    studentMarks.get(i));
        }
        System.out.println("Total Students: " + studentNames.size());
    }

   
    static void searchStudent() {

        System.out.println("\n--- SEARCH STUDENT ---");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        int index = findStudent(name);

        if (index != -1) {

            System.out.println("Student Found!");
            System.out.println("Student ID: " + studentIds.get(index));
            System.out.println("Student Name: " + studentNames.get(index));
            System.out.println("Student Marks: " + studentMarks.get(index));

        } else {
            System.out.println("Student Not Found!");
        }
    }

    static void updateStudent() {

        System.out.println("\n--- UPDATE STUDENT MARKS ---");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        int index = findStudent(name);

        if (index != -1) {

            System.out.println("Student Found!");
            System.out.println("Old Marks: " + studentMarks.get(index));

            int newMarks = readMarks();

            studentMarks.set(index, newMarks);

            System.out.println("Student Marks Updated Successfully!");

            System.out.println("Updated Student Record:");
            System.out.println("Student ID: " + studentIds.get(index));
            System.out.println("Student Name: " + studentNames.get(index));
            System.out.println("Student Marks: " + studentMarks.get(index));

        } else {
            System.out.println("Student Not Found! Cannot Update.");
        }
    }

    static void removeStudent() {

        System.out.println("\n--- REMOVE STUDENT ---");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        int index = findStudent(name);

        if (index != -1) {

            studentIds.remove(index);
            studentNames.remove(index);
            studentMarks.remove(index);

            attendance.remove(name);

            System.out.println("Student Removed Successfully!");

        } else {
            System.out.println("Student Not Found! Cannot Remove.");
        }
    }

    static void addAttendance() {

        System.out.println("\n--- ADD STUDENT ATTENDANCE ---");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        if (!studentNames.contains(name)) {
            System.out.println("Student does not exist!");
            return;
        }

        if (attendance.contains(name)) {
            System.out.println("Attendance Already Marked!");
            return;
        }

        System.out.println("1. Add at Beginning");
        System.out.println("2. Add at End");

        int choice = readInt("Enter Your Choice: ");

        if (choice == 1) {

            attendance.addFirst(name);
            System.out.println("Attendance Added at Beginning!");

        } else if (choice == 2) {

            attendance.addLast(name);
            System.out.println("Attendance Added at End!");

        } else {
            System.out.println("Invalid Choice!");
        }
    }

    static void displayAttendance() {

        System.out.println("\n---------- ATTENDANCE LIST ----------");

        if (attendance.isEmpty()) {
            System.out.println("No Attendance Records Found!");
            return;
        }

        for (String name : attendance) {
            System.out.println(name);
        }

        System.out.println("-------------------------------------");
        System.out.println("Total Present Students: " + attendance.size());
    }

    static void removeAttendance() {

        System.out.println("\n--- REMOVE ATTENDANCE ---");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        if (attendance.contains(name)) {

            attendance.remove(name);
            System.out.println("Attendance Removed Successfully!");

        } else {
            System.out.println("Student Not Found in Attendance List!");
        }
    }
    static void displayStatistics() {

        System.out.println("\n---------- STUDENT STATISTICS ----------");

        if (studentNames.isEmpty()) {
            System.out.println("No Student Records Available!");
            return;
        }

        int highest = Collections.max(studentMarks);
        int lowest = Collections.min(studentMarks);

        int total = 0;
        int above75 = 0;

        for (int marks : studentMarks) {

            total += marks;

            if (marks > 75) {
                above75++;
            }
        }

        double average = (double) total / studentMarks.size();

        System.out.println("Total Students: " + studentNames.size());

        System.out.println("\nHighest Marks: " + highest);

        for (int i = 0; i < studentMarks.size(); i++) {
            if (studentMarks.get(i) == highest) {
                System.out.println("Student: " + studentNames.get(i));
            }
        }

        System.out.println("\nLowest Marks: " + lowest);

        for (int i = 0; i < studentMarks.size(); i++) {
            if (studentMarks.get(i) == lowest) {
                System.out.println("Student: " + studentNames.get(i));
            }
        }

        System.out.println("\nAverage Marks: " + average);

        System.out.println("Students Scoring Above 75: " + above75);
    }

    // Module 7: Sort Student Names
    static void sortStudents() {

        System.out.println("\n--- SORT STUDENT NAMES ---");

        if (studentNames.isEmpty()) {
            System.out.println("No Student Records Available!");
            return;
        }

        System.out.println("1. Alphabetical Order");
        System.out.println("2. Reverse Order");

        int choice = readInt("Enter Your Choice: ");

        // Store original student indexes
        ArrayList<Integer> order = new ArrayList<>();

        for (int i = 0; i < studentNames.size(); i++) {
            order.add(i);
        }

        // Sort indexes based on student names
        Collections.sort(order, (a, b) ->
                studentNames.get(a).compareToIgnoreCase(
                        studentNames.get(b)));

        if (choice == 2) {
            Collections.reverse(order);
        } else if (choice != 1) {
            System.out.println("Invalid Choice!");
            return;
        }

        System.out.println("\nSorted Student Records:");

        for (int index : order) {

            System.out.println(
                    "ID: " + studentIds.get(index)
                    + " | Name: " + studentNames.get(index)
                    + " | Marks: " + studentMarks.get(index));
        }
    }
}