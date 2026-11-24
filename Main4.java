class Device {
    String powerSource = "x";

    void turnOn() {
        System.out.println( powerSource);
    }
}

class Mobile extends Device {
    double screenSize = 33.2;

    void makeCall() {
        System.out.println( screenSize);
    }
}

class Android extends Mobile {
    void openPlayStore() {
        turnOn();
        makeCall();
       
    }
}

class Iphone extends Mobile {
    void openAppStore() {
        turnOn();
        makeCall();
        
    }
}
public class Main4 {
    public static void main(String[] args) {

        Android a = new Android();
        a.openPlayStore();

        Iphone i = new Iphone();
        i.openAppStore();
    }
}