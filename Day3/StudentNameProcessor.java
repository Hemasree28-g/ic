public class StudentNameProcessor {
    public static void main(String[] args) {
        String fullName = " hema sree ";
        String cleanName = fullName.trim();
        String upperName = cleanName.toUpperCase();
        int count = upperName.length();
        int pos = cleanName.indexOf(" ");
        String firstName = cleanName.substring(0, pos);
        String lastName = cleanName.substring(pos + 1);
        boolean result = upperName.startsWith("HEMA");
        System.out.println("Original Name: " + fullName);
        System.out.println("Clean Name: " + cleanName);
        System.out.println("Uppercase Name: " + upperName);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Character Count: " + count);
        System.out.println("Validation Result: " + result);
    }
}