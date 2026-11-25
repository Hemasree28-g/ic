public class ATM21 {
    public static void main(String args[]){
        double balance=10000;
        double withdrawalAmount=0;
        try {
            int result = (int) balance / (int)withdrawalAmount;
               System.out.println("Number of withdrawals: " + result);
        }
        catch(ArithmeticException e){
            System.out.println("Invalid withdrawal amount");
        }
    }
}
