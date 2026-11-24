import java.util.*;
public class Swap {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        System.out.println("Enter num1:");
        a = sc.nextInt();
        System.out.println("Enter num2:");
        b = sc.nextInt();
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After swapping:");
        System.out.println(a);
        System.out.println(b);
        sc.close();
    }
}