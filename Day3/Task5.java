class UsernameValidator {
    String username = "Admin";
    String enteredUsername = "ADMIN";

    void validate() {
        if (username.equalsIgnoreCase(enteredUsername)) {
            System.out.println("Valid Username");
        } else {
            System.out.println("Invalid Username");
        }
    }
}

public class Task5 {
    public static void main(String[] args) {
        UsernameValidator obj = new UsernameValidator();
        obj.validate();
    }
}

