public class Task18 {
    
}
import java.util.TreeMap;
import java.util.Map;

public class Task18 {
    public static void main(String[] args) {

        TreeMap<Integer, Integer> results = new TreeMap<>();

        // Add student results
        results.put(101, 85);
        results.put(102, 90);
        results.put(103, 75);
        results.put(104, 95);
        results.put(105, 80);

        System.out.println("Student Results: " + results);
        results.put(103, 88);
        System.out.println("After Updating: " + results);
        System.out.println("Student 102 Marks: " + results.get(102));
        // Find lowest and highest roll number entries
        Map.Entry<Integer, Integer> first = results.firstEntry();
        Map.Entry<Integer, Integer> last = results.lastEntry();
        int lowestMarks = results.values().stream().min(Integer::compareTo).get();
        int highestMarks = results.values().stream().max(Integer::compareTo).get();
        System.out.println("Lowest Marks: " + lowestMarks);
        System.out.println("Highest Marks: " + highestMarks);
        System.out.println("Results from 102 to 104: " + results.subMap(102, 105));
        System.out.println("Descending Order: " + results.descendingMap());
    }
}