public class ExcepNumber {
    public static void main(String[] args) {
        try{
            String s="abc";
            int number = Integer.parseInt(s);
            System.out.println(number);
        }
        catch(NumberFormatException e){
            System.out.println("can't convert");
        }
    }
}
