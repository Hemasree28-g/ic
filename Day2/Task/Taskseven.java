class Employee {
    double baseSalary;

    double calculateSalary() {
        return baseSalary;
    }
}

// Child class
class SalesEmployee extends Employee {
    double bonus;

    // Method overriding
    @Override
    double calculateSalary() {
        return super.calculateSalary() + bonus;
    }
}

public class Taskseven {
    public static void main(String[] args) {

        SalesEmployee s = new SalesEmployee();

        s.baseSalary = 30000;
        s.bonus = 5000;

        System.out.println("Base Salary: " + s.baseSalary);
        System.out.println("Bonus: " + s.bonus);
        System.out.println("Total Salary: " + s.calculateSalary());
    }
}