import java.util.HashSet;
public class Task7 {
    public static void main(String[] args) {
        HashSet<Integer>  students = new HashSet<>();
       students.add(101);
        students.add(102);
        students.add(103);
        students.add(104);
        students.add(105);
        System.out.println("Student IDs: " + students); 
        students.add(103);
        System.out.println("After Adding Duplicate: " + students);
        students.add(106);
          System.out.println("After Adding New Student: " + students);
        students.remove(102);
        System.out.println("After Removing: " + students);
        System.out.println("Is 104 present:"+students.contains(107));
          System.out.println("Total Registrations: " + students.size());
    }
}
