import java.util.*;
public class AppointmentBooking32 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String patientName = "Rahul";
        int age = 25;
        String appointmentTime = "10:30 AM";

        String[] availableSlots = {
            "09:00 AM", "10:30 AM", "12:00 PM"
        };

        try {
            if (patientName == null)
                throw new NullPointerException();

            System.out.println("Patient Name: " + patientName);
            System.out.println("Name Length: " + patientName.length());

            if (age <= 0)
                throw new IllegalArgumentException();

            System.out.println("Age: " + age);

            System.out.print("Enter appointment slot position (0-2): ");
            int pos = sc.nextInt();

            System.out.println("Appointment Slot: " + availableSlots[pos]);
            System.out.println("Appointment Booked Successfully");

        } catch (NullPointerException e) {
            System.out.println("Patient information is missing");

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid age");

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid appointment slot");

        } finally {
            System.out.println("Appointment Booking Process Completed");
            sc.close();
        }
    }
}
