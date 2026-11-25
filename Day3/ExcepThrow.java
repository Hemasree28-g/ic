public class ExcepThrow {
     static void  checkAge(int age){
        if (age<18){
            throw new ArithmeticException("Access can");
        }
        else{
            System.out.println("Can't");
        }
     }
    public static void main(String[] args) {
        checkAge(15);
    }
}
