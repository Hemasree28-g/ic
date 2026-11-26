import java.util.ArrayList;
import java.util.Collections;

public class Task21 {
    public static void main(String[] args) {

        ArrayList<String> books = new ArrayList<>();
        books.add("Java");
        books.add("Python");
        books.add("C Programming");
        books.add("HTML");
        books.add("SQL");
        System.out.println("Library Books: " + books);
        books.remove("HTML");
        System.out.println("After Removing: " + books);
        books.set(1, "Advanced Python");
        System.out.println("After Updating: " + books);
        System.out.println("Contains Java: " + books.contains("Java"));
        System.out.println("Total Books: " + books.size());
        Collections.reverse(books);
        System.out.println("Reverse Order: " + books);
    }
}