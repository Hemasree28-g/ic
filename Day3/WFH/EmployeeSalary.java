public class EmployeeSalary {


    public void setSalary(double salary) {

        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be greater than zero");
        }
        else {
            System.out.println("Employee Salary: ₹" + salary);
        }
    }

    public static void main(String[] args) {

        EmployeeSalary obj = new EmployeeSalary();

        try {
            obj.setSalary(25000);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            obj.setSalary(50000);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            obj.setSalary(0);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            obj.setSalary(-1000);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}