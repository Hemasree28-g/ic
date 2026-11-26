import java.util.LinkedHashSet;
public class Task11 {
    public static void main(String[] args) {

        LinkedHashSet<String> contacts = new LinkedHashSet<>();
        contacts.add("Hema");
        contacts.add("Sneha");
        contacts.add("Priya");
        contacts.add("Keerthi");
        contacts.add("Sneha");
        System.out.println("Contacts: " + contacts);
        contacts.add("Rahul");
        System.out.println("After Adding: " + contacts);
        contacts.remove("Priya");
        System.out.println("After Removing: " + contacts);
        System.out.println("Contains Hema: " + contacts.contains("Hema"));
        System.out.println("Final Contacts: " + contacts);
    }
}
