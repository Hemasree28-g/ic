class Car{
    Car(){
        System.out.println("This is constructor");
    }
    Car(int a){
        System.out.println("Overloaded constructor");
    }
}

public class OverloadCon {
    public static void main(String[] args) {
        new Car();
        new Car(10);
        
    }
}
