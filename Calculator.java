import java.util.*;
public class Calculator {
    public static void main(String args[]){
         Scanner sc = new Scanner(System.in);
         int a;
         int b;
         int choice;
         System.out.println("enter first number:");
          a = sc.nextInt();
          System.out.println("enter first number:");
          b = sc.nextInt();
        System.out.println("Enter your choice:");
        choice = sc.nextInt();
        switch(choice)
        {
            case 1:
                System.out.println("Addition = "+(a+b));
                break;
            case 2:
                System.out.println("Sub ="+(a-b));
                break;
            case 3:
                System.out.println("Mul ="+(a*b));
                break;
            case 4:
                System.out.println("div = " + (a/b));
                break;
             default:
                System.out.println("Invalid");
        }
        sc.close();
    }
    
}
