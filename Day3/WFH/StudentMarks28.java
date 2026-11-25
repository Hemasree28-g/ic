import java.util.Scanner;

public class StudentMarks28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter marks for 3 subjects:");
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int m3 = sc.nextInt();
            int total = m1 + m2 + m3;
            double average = total / 3.0;
            System.out.println("Total Marks: " + total);
            System.out.println("Average: " + average);
        }
        catch (java.util.InputMismatchException e) {
            System.out.println("Please enter numeric marks only");
        }
        sc.close();
    }
}
