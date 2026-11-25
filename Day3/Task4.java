class PasswordChecker {
    String password;
    String confirmPassword;

    void checkPassword() {
        if (password.equals(confirmPassword)) {
            System.out.println("Password Matched");
        } else {
            System.out.println("Password Mismatch");
        }
    }

    public static void main(String[] args) {

        PasswordChecker obj = new PasswordChecker();
        obj.password = "Java@123";
        obj.confirmPassword = "Java@123";
        obj.checkPassword();
        obj.password = "Java@123";
        obj.confirmPassword = "Java@456";
        obj.checkPassword();
    }
}

