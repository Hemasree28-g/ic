abstract class Employee {
    String name;
    Employee(String name) {
        this.name = name;
    }
    void showName() {
        System.out.println("Employee: " + name);
    }
    abstract void calculateSalary();
}
class FullTimeEmployee extends Employee {
    double monthlySalary = 30000;
    FullTimeEmployee(String name) {
        super(name);
    }
    @Override
    void calculateSalary() {
        System.out.println("Monthly Salary: " + monthlySalary);
    }
}

public class AbstractEle {
    public static void main(String[] args) {
        FullTimeEmployee f = new FullTimeEmployee("Hema");
        f.showName();
        f.calculateSalary();
    }
}