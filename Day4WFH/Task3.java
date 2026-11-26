import java.util.ArrayList;
public class Task3  {
    public static void main(String[] args) {
        ArrayList<String> employees = new ArrayList<>();
        employees.add("Hema");
        employees.add("Sneha");
        employees.add("Priya");
        employees.add("Keerthi");
        employees.add("Navya");

        System.out.println("Present Employees: " + employees);
        employees.add("Sharadha");
        System.out.println("After Adding: " + employees);
        employees.remove("Priya");
        System.out.println("After Removing: " + employees);

       
        System.out.println("Is Priya Present? " + employees.contains("Priya"));

        System.out.println("Total Present Employees: " + employees.size());

        // Display employees in reverse order
        System.out.println("Employees in Reverse Order:");

        for (int i = employees.size() - 1; i >= 0; i--) {
            System.out.println(employees.get(i));
        }
    }
}

