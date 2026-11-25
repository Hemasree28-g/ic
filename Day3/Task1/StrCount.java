import java.util.*;
public class StrCount {
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter string:");
    String c = sc.nextLine();
    int count = 0;
    for(int i=0;i<=c.length();i++){
        count++;
    }
    System.out.println("Count of string:"+count);
 }   
}
