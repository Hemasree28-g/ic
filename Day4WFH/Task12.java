import java.util.LinkedHashSet;
public class Task12 {
    public static void main(String[] args) {
        LinkedHashSet<Integer> visitors = new LinkedHashSet<>();
        visitors.add(101);
        visitors.add(102);
        visitors.add(103);
        visitors.add(104);
        visitors.add(102);
        System.out.println("Visitor IDs: " + visitors);
        visitors.add(105);
        System.out.println("After Adding: " + visitors);

        visitors.remove(103);
        System.out.println("After Removing: " + visitors);
        System.out.println("Visitor 102 visited: " + visitors.contains(102));

        System.out.println("Total Unique Visitors: " + visitors.size());

        System.out.println("Final Visitor IDs: " + visitors);
    }
}
