class TextConverter {
    String message = "Welcome to Java Programming";

    void display() {
  
        System.out.println("Original message: " + message);

        System.out.println("Uppercase: " + message.toUpperCase());

        System.out.println("Lowercase: " + message.toLowerCase());
    }
}

public class Task3  {
    public static void main(String[] args) {
        TextConverter obj = new TextConverter();
        obj.display();
    }
}

