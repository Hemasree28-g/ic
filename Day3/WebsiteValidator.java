public class WebsiteValidator {
    public static void main(String[] args) {
        String url = "https://www.google.com";
        if (url.startsWith("https://")) {
            System.out.println("Secure Website URL");
        } else {
            System.out.println("Invalid Website Protocol");
        }
        url = "http://www.google.com";
        if (url.startsWith("https://")) {
            System.out.println("Secure Website URL");
        } else {
            System.out.println("Invalid Website Protocol");
        }
     
    }
}