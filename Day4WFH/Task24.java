import java.util.TreeSet;

public class Task24 {
    public static void main(String[] args) {

        TreeSet<String> skills = new TreeSet<>();

        skills.add("Java");
        skills.add("Python");
        skills.add("React");
        skills.add("SQL");
        skills.add("MongoDB");

        System.out.println("Course Skills: " + skills);

        skills.add("HTML");
        System.out.println("After Adding Skill: " + skills);

        skills.add("Java");
        System.out.println("After Duplicate Addition: " + skills);

        skills.remove("SQL");
        System.out.println("After Removing SQL: " + skills);

        System.out.println("Contains Python: " + skills.contains("Python"));

        System.out.println("First Skill: " + skills.first());
        System.out.println("Last Skill: " + skills.last());

        System.out.println("Descending Order: " + skills.descendingSet());
    }
}