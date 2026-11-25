import java.util.*;
public class StrEqual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter String1:");
        String s1= sc.nextLine();
        System.out.println("enter String2:");
        String s2 =sc.nextLine();
        if(s1.equals(s2)){
            System.out.println("is equal");
        }
        else{
            System.out.println("is not eqaual");
        }
    }
}
