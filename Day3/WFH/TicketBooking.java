public class TicketBooking {
    public static void main(String[] args) {
        String passengerName = "Rahul";
        try{
            System.out.println(passengerName.charAt(0));
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("position invalid");
        }
         try{
            System.out.println(passengerName.charAt(2));
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("position invalid");
        }
         try{
            System.out.println(passengerName.charAt(4));
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("position invalid");
        }
         try{
            System.out.println(passengerName.charAt(5));
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("position invalid");
        }
         try{
            System.out.println(passengerName.charAt(-1));
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("position invalid");
        }
    }
}
