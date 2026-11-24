class UserRegistration{
    void register(String name, int userId){
        System.out.println("Registered user: " + name + " with ID: " + userId
);
    }
    void register(int userId, String name){
       System.out.println("Registered ID: " + userId + " for user: " + name
);
    }
}
public class Taskfive {
  public static void main(String[] args) {
    UserRegistration us = new UserRegistration();
    us.register("hema", 65);
    us.register(17, "Sneha");
  }  
}
