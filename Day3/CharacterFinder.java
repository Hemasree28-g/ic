public class CharacterFinder {
    String word = "Programming";

    public static void main(String[] args) {

        CharacterFinder obj = new CharacterFinder();

        int a = obj.word.indexOf('g');
        int b = obj.word.indexOf('m');
        int c = obj.word.indexOf('z');

        System.out.println("First occurrence of g: " + a);
        System.out.println("Position of m: " + b);
        System.out.println("Position of z: " + c);
    }
}

