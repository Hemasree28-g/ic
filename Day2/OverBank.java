class Bank {
    double getInterestRate() {
        return 0.0;
    }
}

class SBI extends Bank {
    @Override
    double getInterestRate() {
        return 6.5;
    }
}

class HDFC extends Bank {
    @Override
    double getInterestRate() {
        return 7.0;
    }
}

public class OverBank {
    public static void main(String[] args) {

        SBI s = new SBI();
        System.out.println("SBI:"+ s.getInterestRate());

        HDFC h = new HDFC();
        System.out.println("HDFC:"+ h.getInterestRate());
    }
}