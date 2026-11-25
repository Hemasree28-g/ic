import java.util.HashSet;
public class CHSet {
    public static void main(String[] args) {
        HashSet<String> h = new HashSet<>();
        h.add("Java");
        h.add("Python");
        h.add("React");
        h.add("Java");
        System.out.println(h);
        System.out.println("Contains Java:"+h.contains("Java"));
        h.remove("Python");
        System.out.println("After Remove:"+h);
    }
}
