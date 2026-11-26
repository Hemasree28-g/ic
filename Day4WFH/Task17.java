import java.util.TreeMap;

public class Task17 {
    public static void main(String[] args) {

        TreeMap<Integer, String> students = new TreeMap<>();
        students.put(105, "Hema");
        students.put(102, "Sneha");
        students.put(104, "Priya");
        students.put(101, "Keerthi");
        students.put(103, "Rahul");

        System.out.println("Student Records: " + students);

        students.put(102, "Anu");
        System.out.println("After Updating: " + students);

        System.out.println("Student 103: " + students.get(103));

        students.remove(104);
        System.out.println("After Removing: " + students);

        System.out.println("First Roll Number: " + students.firstKey());
        System.out.println("Last Roll Number: " + students.lastKey());

        System.out.println("Descending Order: " + students.descendingMap());

        System.out.println("Roll Numbers 102 to 105: " + students.subMap(102, 106));
    }
}
