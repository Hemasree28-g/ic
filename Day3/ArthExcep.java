public class ArthExcep {
    public static void main(String args[]){
    int a=10;
    int b=0;
    try{
        int ans = a/b;
    }
    catch (ArithmeticException e){
        System.out.println("its wrong");
    }
 }
}