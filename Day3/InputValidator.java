public class InputValidator {
    public static void main(String[] args) {
        String userInput = " ";
        if (userInput.isBlank()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("Valid Input");
        }
        userInput = "";
        if (userInput.isBlank()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("Valid Input");
        }

        userInput = "hema";

        if (userInput.isBlank()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("Valid Input");
        }
    }
}