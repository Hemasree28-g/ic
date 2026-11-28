class Calculate{
    void add(int a,int b){
        System.out.println(a+b);
    }
     void add(int a,int b,int c){
        System.out.println(a+b+c);
    }
     void add(float a,float b){
        System.out.println(a+b);
    }
}
public class TwoOverload {
    public static void main(String[] args) {
        Calculate c = new Calculate();
        c.add(2.3f, 3.0f);
    }
    
}
