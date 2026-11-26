import java.util.TreeMap;

public class Task27 {
    public static void main(String[] args) {

        TreeMap<Integer, String> employees = new TreeMap<>();

        employees.put(105, "HR");
        employees.put(102, "IT");
        employees.put(104, "Finance");
        employees.put(101, "Sales");
        employees.put(103, "Marketing");

        System.out.println("Employee Records: " + employees);

        employees.put(102, "Development");
        System.out.println("After Updating: " + employees);

        int id = 103;

        if (employees.containsKey(id)) {
            System.out.println("Employee Department: " + employees.get(id));
        } else {
            System.out.println("Employee Not Found");
        }

        employees.remove(104);
        System.out.println("After Removing: " + employees);

        System.out.println("Ascending Order: " + employees);

        System.out.println("First Employee ID: " + employees.firstKey());
        System.out.println("Last Employee ID: " + employees.lastKey());

        System.out.println("Descending Order: " + employees.descendingMap());

        System.out.println("Employees from ID 102 to 105: "
                + employees.subMap(102, 106));
    }
}