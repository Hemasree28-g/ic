public class TextEditor {
    String sentence = "I love Python Programming";
    public void editText() {
        String m = sentence.replace("Python", "Java");
        String r= sentence.replace('o', '0');

        System.out.println("Original Sentence: " + sentence);
        System.out.println("After replacing Python with Java: " + m);
        System.out.println("After replacing o with 0: " + r);
    }

    public static void main(String[] args) {
        TextEditor t = new TextEditor();
        t.editText();
    }
}
  
