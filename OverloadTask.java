class Calculator{
    void add(int a,int b){
        System.out.println("Sum of two numbers"+(a+b));
    }
    void add(int a,int b,int c){
        System.out.println("Sum of Three integers"+(a+b+c));
    }
}
public class OverloadTask {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.add(2, 3);
        cal.add(2,3,4);
    }
}
