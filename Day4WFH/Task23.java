import java.util.HashSet;

public class Task23 {
    public static void main(String[] args) {
        HashSet<Integer> event1 = new HashSet<>();

        event1.add(101);
        event1.add(102);
        event1.add(103);
        event1.add(104);
        event1.add(102); 

        System.out.println("Event 1 Registrations: " + event1);

        event1.remove(104);
        System.out.println("After Cancellation: " + event1);

        System.out.println("Student 101 Registered: " + event1.contains(101));

        System.out.println("Total Registrations: " + event1.size());


        HashSet<Integer> event2 = new HashSet<>();

        event2.add(102);
        event2.add(103);
        event2.add(105);
        event2.add(106);

        System.out.println("Event 2 Registrations: " + event2);


        HashSet<Integer> bothEvents = new HashSet<>(event1);

        bothEvents.retainAll(event2);

        System.out.println("Students Registered for Both Events: " + bothEvents);

        HashSet<Integer> allStudents = new HashSet<>(event1);

        allStudents.addAll(event2);

        System.out.println("All Unique Students: " + allStudents);
        System.out.println("Total Unique Students: " + allStudents.size());
    }
}