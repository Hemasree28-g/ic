import java.util.*;
class Animal {
    String name;
    void eat(){
        System.out.println( "is eating" +name);
    }
}
class Dog extends Animal{
    String breed;
    void bark(){
        System.out.println(name+ "the" +breed +"is barking");
    }
}

public class MainAn {
    public static void main(String args[]) {
        Dog d = new Dog();

        d.name = "Tommy";
        d.breed = "S";

        d.eat();
        d.bark();
    }
    
}
