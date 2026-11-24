interface Shape {
    void calculateArea(double value);
}

class Square implements Shape {
    public void calculateArea(double side) {
        System.out.println("Square: " + (side * side));
    }
}

class Circle implements Shape {
    public void calculateArea(double radius) {
        System.out.println("Circle: " + (3.14 * radius * radius));
    }
}

public class Interfour {
    public static void main(String[] args) {

        Shape s1 = new Square();
        Shape s2 = new Circle();

        s1.calculateArea(5.0);
        s2.calculateArea(5.0);
    }
}