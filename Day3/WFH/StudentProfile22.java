public class StudentProfile22 {
    public static void main(String args[]){
    String studentName = null;
    try{
        System.out.println("length:"+studentName.length());
    }  
    catch(NullPointerException e){
        System.out.println("Student name is not available");
    }
    studentName = "hema";
    try{
        System.out.println("length:"+studentName.length());
    }  
    catch(NullPointerException e){
        System.out.println("Student name is not available");
    }
}
}