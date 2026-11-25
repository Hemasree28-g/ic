public class WordAnalyzer {

    String word = "banana";

    public void analyzeWord() {
        int firstA = word.indexOf('a');
        int firstN = word.indexOf('n');
        int lastA = word.lastIndexOf('a');
        int lastN = word.lastIndexOf('n');

        System.out.println("Word: " + word);
        System.out.println("First occurrence of 'a': " + firstA);
        System.out.println("Last occurrence of 'a': " + lastA);
        System.out.println("First occurrence of 'n': " + firstN);
        System.out.println("Last occurrence of 'n': " + lastN);
    }

    public static void main(String[] args) {

        WordAnalyzer obj = new WordAnalyzer();
        obj.analyzeWord();
    }
}