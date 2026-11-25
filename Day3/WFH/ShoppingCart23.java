public class ShoppingCart23 {
    public static void main(String[] args) {
        String[] things={"Laptop", "Mobile", "Headphones", "Keyboard", "Mouse"};
        try{
            System.out.println("position 1:"+things[1]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid position");
        }
         try{
            System.out.println("position 3:"+things[3]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid position");
        }
         try{
            System.out.println("position 5:"+things[5]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid position");
        }
         try{
            System.out.println("position 8:"+things[8]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid position");
        }
    }
}
