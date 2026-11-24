abstract class Shape {

    abstract double calculateArea();

    void displayMessage() {
        System.out.println("Calculating area of the shape...");
    }
}
class Circle extends Shape {
    double radius = 3.3;
    @Override
    double calculateArea() {
        return 3.14 * radius * radius;
    }
}
public class Abstractten {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.displayMessage();
        System.out.println("Area" + c.calculateArea());
    }
}