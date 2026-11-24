
class UniversityMember {
    int memberId;

    void checkIn() {
        System.out.println("Member checked in");
    }
}

class Staff extends UniversityMember {
    String department;

    void attendMeeting() {
        System.out.println(department);
        System.out.println("Attending meeting");
    }
}

class Professor extends Staff {
    String subject;

    void conductLecture() {
        System.out.println(subject);
        System.out.println("Conducting lecture");
    }
}

class AdminOfficer extends Staff {
    String officeRoom;

    void processFiles() {
        System.out.println(officeRoom);
        System.out.println("Processing files");
    }
}

public class MainGrand {
    public static void main(String[] args) {

        Professor p = new Professor();

        p.memberId = 101;
        p.department = "Computer Science";
        p.subject = "Java";

        System.out.println("Professor Details:");
        p.checkIn();
        p.attendMeeting();
        p.conductLecture();

        AdminOfficer a = new AdminOfficer();

        a.memberId = 102;
        a.department = "Administration";
        a.officeRoom = "Room 205";

        System.out.println("\nAdmin Officer Details:");
        a.checkIn();
        a.attendMeeting();
        a.processFiles();
    }
}
