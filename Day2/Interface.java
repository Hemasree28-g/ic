interface Payment{
    void pay();
}
class UPI implements Payment{
    public void pay(){
        System.out.println("done");
    }
}
public class Interface {
    public static void main(String[] args) {
        UPI u = new UPI();
        u.pay();
    }
    
}
