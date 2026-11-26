import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
         students.add("Hema");
        students.add("Sneha");
        students.add("Priya");
        students.add("Keerthi");
        students.add("sharadha");
        students.add("Navaya");
        students.add("Rupa");
        students.add("hithu");
        students.add("Reddy");
        students.add("Teja");

        System.out.println("Ten student names:"+students);

        students.add(1,"Deepu");
        System.out.println("After addiing:"+students);

        students.remove("Rupa");
        System.out.println("After removing:"+students);

        students.set(3,"Keeru");
        System.out.println("After update:"+students);

       
        System.out.println("Is Teja Exists? " + students.contains("Priya"));

        System.out.println("Student at index 2: " + students.get(2));

        System.out.println("Total Students: " + students.size());

    }
}
