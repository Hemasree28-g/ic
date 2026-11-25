import java.util.*;
public class StrChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string:");
        String c = sc.nextLine();
        for(int i=0;i<c.length();i++){
        System.out.println("each char:"+ c.charAt(i));
        }
    }
}
