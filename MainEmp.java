
class Employee {
    String name;
    double baseSalary;

    void displayBasicInfo() {
        System.out.println(name);
        System.out.println(baseSalary);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    void writeCode() {
        System.out.println(programmingLanguage);
    }
}

class Tester extends Employee {
    String testingTool;

    void runTests() {
        System.out.println(testingTool);
    }
}

public class MainEmp {
    public static void main(String[] args) {

        Developer d = new Developer();

        d.name = "Rahul";
        d.baseSalary = 50000;
        d.programmingLanguage = "Java";

        d.displayBasicInfo();
        d.writeCode();

        Tester t = new Tester();

        t.name = "Ravi";
        t.baseSalary = 40000;
        t.testingTool = "Selenium";

        t.displayBasicInfo();
        t.runTests();
    }
}
