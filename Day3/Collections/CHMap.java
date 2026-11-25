import java.util.HashMap;

public class CHMap {
    public static void main(String[] args) {

        HashMap<Integer, String> h = new HashMap<>();

        h.put(101, "hema");
        h.put(102, "sneha");
        h.put(103, "keerthi");

        System.out.println(h);

        System.out.println("h 101: " + h.get(101));

        h.put(102, "priya");

        h.remove(103);

        System.out.println("Update: " + h);
    }
}