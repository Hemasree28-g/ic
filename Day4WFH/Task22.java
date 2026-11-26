import java.util.LinkedList;
public class Task22 {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast("Hema");
        queue.addLast("Sneha");
        queue.addLast("Priya");
        queue.addLast("Keerthi");
        System.out.println("Customer Queue: " + queue);
        queue.addFirst("Rahul");
        System.out.println("After Emergency Customer: " + queue);

        System.out.println("Waiting Customers: " + queue);

        System.out.println("Serving Customer: " + queue.poll());

        System.out.println("Next Customer: " + queue.peek());

        
        queue.remove("Priya");
        System.out.println("After Removing Priya: " + queue);

        
        System.out.println("Total Waiting Customers: " + queue.size());

        
        while (!queue.isEmpty()) {
            System.out.println("Serving: " + queue.poll());
        }

        System.out.println("Queue Empty: " + queue.isEmpty());
    }
}
