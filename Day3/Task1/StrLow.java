import  java.util.*;
public class StrLow{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.print("Enter a string: ");
        String l = sc.nextLine();
        String lower = l.toLowerCase();
        System.out.println("Lower:"+lower);
    }
}
