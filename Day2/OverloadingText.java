class Printer{
    void print(String text){
        System.out.println("Text:"+text);
    }
    void print(int number){
        System.out.println("Integer:"+number);
    }
    void print(double decimal){
        System.out.println("Decimal:"+decimal);
    }
}
public class OverloadingText {
    public static void main(String[] args) {
        Printer p = new Printer();
        p.print("hema");
        p.print(1);
        p.print(2.0);
    }
}
