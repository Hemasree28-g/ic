import java.util.TreeSet;

public class Task10 {
    public static void main(String[] args) {

        TreeSet<Integer> scores = new TreeSet<>();

        // Add exam scores
        scores.add(85);
        scores.add(90);
        scores.add(75);
        scores.add(95);
        scores.add(80);
        scores.add(90);

        System.out.println("Exam Scores: " + scores);

        System.out.println("Lowest Score: " + scores.first());
        System.out.println("Highest Score: " + scores.last());

        // Find higher and lower scores
        int score = 85;

        System.out.println("Next Higher Score: " + scores.higher(score));
        System.out.println("Next Lower Score: " + scores.lower(score));

        // Display scores in descending order
        System.out.println("Descending Order: " + scores.descendingSet());
    }
}
