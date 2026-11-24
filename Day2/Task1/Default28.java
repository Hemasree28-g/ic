interface SmartDevice {
    void connectWifi();
    default void deviceStatus() {
        System.out.println("Smart device is ready");
    }
}
class SmartTV implements SmartDevice {
    public void connectWifi() {
        System.out.println("Smart TV connected to WiFi");
    }
}
class SmartWatch implements SmartDevice {
    public void connectWifi() {
        System.out.println("Smart Watch connected to WiFi");
    }
}
public class Default28 {
    public static void main(String[] args) {
        SmartDevice sd1 = new SmartTV();
        sd1.connectWifi();
        sd1.deviceStatus();
        SmartDevice sd2 = new SmartWatch();
        sd2.connectWifi();
        sd2.deviceStatus();
    }
}