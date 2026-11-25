public class InputCleaner {

    String username = " JavaDeveloper ";

    public void cleanInput() {
        System.out.println("Original String: '" + username + "'");
        System.out.println("Original String Length: " + username.length());
        String cleanedUsername = username.trim();
        System.out.println("Cleaned Username: '" + cleanedUsername + "'");
        System.out.println("Cleaned String Length: " + cleanedUsername.length());
    }

    public static void main(String[] args) {
        InputCleaner obj = new InputCleaner();
        obj.cleanInput();
    }
}