public class FileValidator {
    public static void main(String[] args) {
        String fileName = "student_report.pdf";
        if (fileName.endsWith(".pdf")) {
            System.out.println("PDF File");
        } else {
            System.out.println("Different File Format");
        }
        fileName = "student_photo.jpg";
        if (fileName.endsWith(".pdf")) {
            System.out.println("PDF File");
        } else {
            System.out.println("Different File Format");
        }
        fileName = "student_details.docx";
        if (fileName.endsWith(".pdf")) {
            System.out.println("PDF File");
        } else {
            System.out.println("Different File Format");
        }
    }
}