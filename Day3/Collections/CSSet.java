import java.util.LinkedHashSet;
public class CSSet {
    public static void main(String[] args) {
        LinkedHashSet<String> h = new LinkedHashSet<>();
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
