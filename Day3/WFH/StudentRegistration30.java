import java.util.*;
public class StudentRegistration30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
          String studentName;
         int age;
        String marks;
         String[] subjects = new String[4];
          System.out.println("Enter student name:");
    studentName = sc.nextLine();

    if (studentName.equalsIgnoreCase("null")) {
        studentName = null;
    }

    System.out.println("Enter age:");
    age = sc.nextInt();
    sc.nextLine();

    System.out.println("Enter marks:");
    marks = sc.nextLine();

    System.out.println("Enter 4 subjects:");

    for (int i = 0; i < subjects.length; i++) {
        subjects[i] = sc.nextLine();
    }

    System.out.println("Enter subject position (0-3):");
    int position = sc.nextInt();

    try {
        System.out.println("Name length: " + studentName.length());

        int studentMarks = Integer.parseInt(marks);
        System.out.println("Marks: " + studentMarks);

        System.out.println("Subject: " + subjects[position]);

        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than zero");
        }

        System.out.println("Student Registration Completed");
    }

    catch (NullPointerException e) {
        System.out.println("Student name is not available");
    }

    catch (NumberFormatException e) {
        System.out.println("Invalid marks format");
    }

    catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Invalid subject position");
    }

    catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
    }
}
