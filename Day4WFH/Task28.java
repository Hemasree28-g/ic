import java.util.LinkedHashMap;
import java.util.Map;

public class Task28 {
    public static void main(String[] args) {

        LinkedHashMap<Integer, String> orders = new LinkedHashMap<>();

        orders.put(101, "Preparing");
        orders.put(102, "Packed");
        orders.put(103, "Out for Delivery");
        orders.put(104, "Preparing");
        orders.put(105, "Delivered");

        System.out.println("Customer Orders: " + orders);

        orders.put(101, "Packed");
        orders.put(102, "Out for Delivery");

        System.out.println("After Updating Status: " + orders);

        int orderId = 103;

        if (orders.containsKey(orderId)) {
            System.out.println("Order Status: " + orders.get(orderId));
        } else {
            System.out.println("Order Not Found");
        }

        orders.remove(104);
        System.out.println("After Cancelling Order: " + orders);

        System.out.println("All Orders:");

        for (Map.Entry<Integer, String> entry : orders.entrySet()) {
            System.out.println("Order ID: " + entry.getKey()
                    + ", Status: " + entry.getValue());
        }

        int preparing = 0;
        int packed = 0;
        int outForDelivery = 0;
        int delivered = 0;

        for (String status : orders.values()) {

            if (status.equals("Preparing")) {
                preparing++;
            } else if (status.equals("Packed")) {
                packed++;
            } else if (status.equals("Out for Delivery")) {
                outForDelivery++;
            } else if (status.equals("Delivered")) {
                delivered++;
            }
        }

        System.out.println("Preparing Orders: " + preparing);
        System.out.println("Packed Orders: " + packed);
        System.out.println("Out for Delivery Orders: " + outForDelivery);
        System.out.println("Delivered Orders: " + delivered);

        System.out.println("Preparing Count: "
                + orders.values().stream()
                .filter(s -> s.equals("Preparing"))
                .count());
    }
}
