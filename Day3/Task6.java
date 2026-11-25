public class Task6{

    String email = "student@gmail.com";

    public void checkEmail() {

        if (email.contains("@")) {
            System.out.println("Email contains @");
        } else {
            System.out.println("Email does not contain @");
        }

        if (email.contains("gmail")) {
            System.out.println("Email contains gmail");
        } else {
            System.out.println("Email does not contain gmail");
        }
    }

    public static void main(String[] args) {
        Task6 obj1 = new Task6();
        obj1.email = "student@gmail.com";
        obj1.checkEmail();
        Task6 obj2 = new Task6();
        obj2.email = "student@yahoo.com";
        obj2.checkEmail();

        Task6 obj3 = new Task6();
        obj3.email = "studentgmail.com";
        obj3.checkEmail();
    }
}

