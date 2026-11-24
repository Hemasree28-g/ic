class Account {
    int accountNumber;
 void showAccount(){
    System.out.println(accountNumber);
 }
}
class  SavingsAccount extends Account {
    double interestRate;
    void showSavingsDetails(){
            System.out.println(interestRate );
    }
}
class FixedDepositAccount extends SavingsAccount{
    int lockInYears;
    void showFDDetails(){
       System.out.println(lockInYears);  
    }
}
public class MainAcc {
    public static void main(String args[]){
     FixedDepositAccount fd = new FixedDepositAccount();

     fd.accountNumber=765;
     fd.interestRate=6.6;
     fd. lockInYears=2026;
        fd.showAccount();
        fd.showSavingsDetails();
        fd.showFDDetails();


    } 
}
