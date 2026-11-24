interface Printable {
    void printDocument();
}

interface Scannable {
    void scanDocument();
}

class SmartPrinter implements Printable, Scannable {

    public void printDocument() {
        System.out.println("Printing document...");
    }

    public void scanDocument() {
        System.out.println("Scanning document...");
    }
}

public class Interfive {
    public static void main(String[] args) {

        SmartPrinter obj = new SmartPrinter();

        obj.printDocument();
        obj.scanDocument();
    }
}