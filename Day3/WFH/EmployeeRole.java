class Manager {
}
class Developer {
}
public class EmployeeRole {
    public static void main(String[] args) {

        Object obj = new Developer();
        try {
            Manager m = (Manager) obj;
            System.out.println("Manager object created successfully");
        }
        catch (ClassCastException e) {
            System.out.println("Invalid Employee Role Conversion");
        }

        obj = new Manager();

        try {
            Manager m = (Manager) obj;
            System.out.println("Manager object created successfully");
        }
        catch (ClassCastException e) {
            System.out.println("Invalid Employee Role Conversion");
        }
    }
}
