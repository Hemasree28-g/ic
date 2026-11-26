import java.util.HashMap;
public class Task16 {
    public static void main(String[] args) {

        HashMap<String, String> contacts = new HashMap<>();
        contacts.put("Hema", "9843210");
        contacts.put("Sneha", "9543211");
        contacts.put("Priya", "98212");
        contacts.put("Keerthi", "98213");

        System.out.println("Contact List: " + contacts);

        contacts.put("Hema", "9999999999");
        System.out.println("After Updating: " + contacts);

        System.out.println("Hema Phone Number: " + contacts.get("Hema"));

        System.out.println("Contains Sneha: " + contacts.containsKey("Sneha"));

        contacts.remove("Priya");
        System.out.println("After Removing: " + contacts);

        System.out.println("Number Exists: " + contacts.containsValue("9876543211"));

        System.out.println("Final Contact List: " + contacts);
    }
}
