class Student {
    private String name = "A";
    private int rollnumber = 1;

    // Getter for name
    public void getter() {
        System.out.println(name);
    }

    // Setter for name
    public void setter(String a) {
        name = a;
    }

    // Getter for rollnumber
    public void getRollnumber() {
        System.out.println(rollnumber);
    }

    // Setter for rollnumber
    public void setRollnumber(int r) {
        rollnumber = r;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();

        s.getter();
        s.setter("hema");
        s.getter();

        s.getRollnumber();
        s.setRollnumber(101);
        s.getRollnumber();
    }
}