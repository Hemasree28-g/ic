abstract class Vechical{
    abstract void start();
    void run(){
        System.out.println("Hello world");
    }
}
class Bike extends Vechical{
    @Override 
    void start(){
        System.out.println("Starting");
    }
}
public class Abstract {
    public static void main(String[] args) {
        Bike b = new Bike();
        b.start();
        b.run();
    }
    
}
