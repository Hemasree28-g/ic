import java.util.HashMap;
import java.util.TreeSet;
import java.util.Map;

public class Task30 {
    public static void main(String[] args) {

        HashMap<String, Integer> students = new HashMap<>();

        students.put("Hema", 95);
        students.put("Sneha", 85);
        students.put("Priya", 75);
        students.put("Keerthi", 90);
        students.put("Rahul", 60);

        TreeSet<Integer> marks = new TreeSet<>();

        marks.addAll(students.values());

        System.out.println("Student Marks:");

        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("Highest Marks: " + marks.last());
        System.out.println("Lowest Marks: " + marks.first());

        System.out.println("Unique Marks: " + marks);

        System.out.println("Students Scoring Above 80:");

        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            if (entry.getValue() > 80) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }

        int total = 0;

        for (int mark : students.values()) {
            total = total + mark;
        }

        double average = (double) total / students.size();

        System.out.println("Class Average: " + average);


        System.out.println("Top Performing Student(s):");

        int highest = marks.last();

        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            if (entry.getValue() == highest) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }

        int pass = 0;
        int fail = 0;

        for (int mark : students.values()) {
            if (mark >= 40) {
                pass++;
            } else {
                fail++;
            }
        }

        System.out.println("Passed Students: " + pass);
        System.out.println("Failed Students: " + fail);
    }
}