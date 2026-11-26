import java.util.LinkedList;
public class Task5 {
    public static void main(String[] args) {
        LinkedList<String> url=new LinkedList<>();
        url.add("www.google.com");
        url.add("www.youtube.com");
       url.add("www.facebook.com");
       url.add("www.instagram.com");
        url.add("www.amazon.com");
       System.out.println("Browsing History: " + url);
       url.add("www.flipkart.com");
        System.out.println("After Adding: " + url);
         url.removeLast();
        System.out.println("After Removing Last: " + url);
        System.out.println("First Visited Website: " + url.getFirst());
        System.out.println("Last Visited Website: " + url.getLast());
         System.out.println("Is Google Visited? " + url.contains("www.google.com"));
          url.clear();
        System.out.println("After Clearing History: " +url);

    }
    
}
