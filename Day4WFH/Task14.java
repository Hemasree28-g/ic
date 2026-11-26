import java.util.HashMap;
import java.util.Map;

public class Task14 {
    public static void main(String[] args) {

        HashMap<Integer, Integer> employees = new HashMap<>();
        employees.put(101, 30000);
        employees.put(102, 40000);
        employees.put(103, 25000);
        employees.put(104, 50000);
        System.out.println("Employee Records: " + employees);
        employees.replace(102, 45000);
        System.out.println("After Updating: " + employees);
        System.out.println("Employee 103 Salary: " + employees.get(103));

        int highestSalary = 0;
        int employeeId = 0;

        for (Map.Entry<Integer, Integer> e : employees.entrySet()) {
            if (e.getValue() > highestSalary) {
                highestSalary = e.getValue();
                employeeId = e.getKey();
            }
        }

        System.out.println("Highest Salary Employee ID: " + employeeId);
        System.out.println("Highest Salary: " + highestSalary);

        int total = 0;

        for (int salary : employees.values()) {
            total = total + salary;
        }

        System.out.println("Total Salary Expenditure: " + total);
    }
}