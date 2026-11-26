import java.util.TreeSet;

public class Task9{
    public static void main(String[] args) {

        TreeSet<Integer> employees = new TreeSet<>();
        employees.add(105);
        employees.add(102);
        employees.add(108);
        employees.add(101);
        employees.add(106);
        employees.add(103);

        System.out.println("Employee IDs: " + employees);

        employees.add(110);
        System.out.println("After Adding: " + employees);

        employees.remove(105);
        System.out.println("After Removing: " + employees);

        System.out.println("Smallest ID: " + employees.first());
        System.out.println("Largest ID: " + employees.last());

        int id = 106;

        System.out.println("Next Higher ID: " + employees.higher(id));
        System.out.println("Next Lower ID: " + employees.lower(id));

        // Display IDs within a range
        System.out.println("IDs between 102 and 108: " + employees.subSet(102, 109));

        // Display IDs less than 106
        System.out.println("IDs below 106: " + employees.headSet(106));

        // Display IDs greater than or equal to 106
        System.out.println("IDs from 106 onwards: " + employees.tailSet(106));
    }
}