import java.util.LinkedList;
public class CLlist {
    public static void main(String[] args) {
        LinkedList<String> s = new LinkedList<>();
        s.add("Learn java");
        s.add("Learn sql");
        s.add("Learn React");
        s.addFirst("Start");
        s.addLast("End");

        System.out.println(s);
        s.removeFirst();
        s.removeLast();
        System.out.println("After removing:"+s);



    }
}
