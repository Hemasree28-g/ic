public class NameExtractor {

    String fullName = "Java Full Stack Developer";

    public void extractName() {
        String word1 = fullName.substring(0, 4);
        String word2 = fullName.substring(5, 9);
        String remainingText = fullName.substring(10);
        System.out.println("First Word: " + word1);
        System.out.println("Second Word: " + word2);
        System.out.println("Remaining Text: " + remainingText);
    }
    public static void main(String[] args) {
        NameExtractor obj = new NameExtractor();
        obj.extractName();
    }
}

