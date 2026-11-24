class Parent {
    void name() {
        System.out.println("parent");
    }
}

class Child extends Parent {

}

public class Inher {
    public static void main(String[] args) {
        Child ch = new Child();
        ch.name();
    }
}