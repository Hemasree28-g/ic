public class EmailValidation {
    public static void main(String[] args) {
        String email = "studenthema@gmail.com";
        if (!email.isEmpty() &&email.contains("@") &&
            email.endsWith(".com") &&
            email.startsWith("student")) {
            System.out.println("Valid Email");
        } else {
            System.out.println("Invalid Email");
        }
        email = "hema@gmail.com";
        if (!email.isEmpty() &&
            email.contains("@") &&
            email.endsWith(".com") &&
            email.startsWith("student")) {
            System.out.println("Valid Email");
        } else {
            System.out.println("Invalid Email");
        }
        email = "student565@gmail.in";
        if (!email.isEmpty() &&
            email.contains("@") &&
            email.endsWith(".com") &&
            email.startsWith("student")) {
            System.out.println("Valid Email");
        } else {
            System.out.println("Invalid Email");
        }
    }
}