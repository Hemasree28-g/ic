public class StudentDetails {
    public static void main(String[] args) {

        String details = "Hema,65,Java,90";

        String[] data = details.split(",");

        System.out.println("Name: " + data[0]);
        System.out.println("Age: " + data[1]);
        System.out.println("Course: " + data[2]);
        System.out.println("Marks: " + data[3]);
    }
}
