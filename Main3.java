class Person{
    String name = "hema";
    void displayPerson(){
         System.out.println(name);
    }
}
class Employee extends Person{
    int employeeId =565;
    void displayEmployee(){
         System.out.println(employeeId);
    }
}
class Manager extends Employee{
    String department="A";
    void diaplayManager(){
        System.out.println(department);
    }
}
public class Main3 {
    public static void main(String args[]){
        Manager ob = new Manager();
        ob.displayPerson();
        ob.displayEmployee();
        ob.diaplayManager();
    }
}
