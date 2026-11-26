import java.util.HashMap;

public class Task13 {
    public static void main(String[] args) {

        HashMap<String, Integer> students = new HashMap<>();
        students.put("Hema", 85);
        students.put("Sneha", 90);
        students.put("Priya", 80);
        students.put("Keerthi", 95);
        System.out.println("Student Records: " + students);

        students.put("Hema", 92);
        System.out.println("After Updating: " + students);

        System.out.println("Hema Marks: " + students.get("Hema"));

        System.out.println("Contains Sneha: " + students.containsKey("Sneha"));

        students.remove("Priya");
        System.out.println("After Removing: " + students);

        System.out.println("Student Names: " + students.keySet());
        System.out.println("Student Marks: " + students.values());

        int sum = 0;

        for (int marks : students.values()) {
            sum = sum + marks;
        }

        double average = (double) sum / students.size();

        System.out.println("Average Marks: " + average);
    }
}
