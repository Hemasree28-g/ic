class Calculate{
    void add(int a,int b){
        System.out.println(a+b);
    }
}
class Math extends Calculate{
    @Override 
    void add(int a,int b){
        System.out.println(a+b);
    }
}
public class TwoOverride {
    
}
