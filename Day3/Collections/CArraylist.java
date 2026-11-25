import java.util.ArrayList;
class CArraylist{
    public static void main(String[] args) {
        ArrayList<Integer>num=new ArrayList<>(); // arraylist
        num.add(10);
        System.out.println(num.get(0)); // at particular index
        num.remove(0);
        System.out.println(num);
    }
}