public class ExcepString {
    public static void main(String[] args) {
        String s = "Hema";
        try{
            System.out.println(s.charAt(8));   
         }
         catch(StringIndexOutOfBoundsException e){
            System.out.println("no index found");
         }
    }
}
