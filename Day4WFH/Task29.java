import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Task29 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a paragraph:");
        String paragraph = sc.nextLine();

        paragraph = paragraph.toLowerCase();

        paragraph = paragraph.replaceAll("[^a-zA-Z0-9\\s]", "");

        String[] words = paragraph.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequencies:");

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        String maxWord = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxWord = entry.getKey();
            }
        }

        System.out.println("Most Frequent Word: " + maxWord);
        System.out.println("Frequency: " + maxCount);

        System.out.println("Unique Words: " + map.size());

        sc.close();
    }
}