import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Library extends LibraryOperations {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<LibraryMember> members = new ArrayList<>();
    private HashMap<Integer, Book> bookMap = new HashMap<>();
    private LinkedHashMap<Integer, IssueRecord> issueRecords = new LinkedHashMap<>();
    private HashSet<Integer> issuedBookIds = new HashSet<>();

    private int nextMemberId = 1001;
    private int nextIssueId = 1;

    @Override
    public void addBook(Book book) {
        if (bookMap.containsKey(book.getBookId())) {
            System.out.println("Book ID already exists.");
            return;
        }
        books.add(book);
        bookMap.put(book.getBookId(), book);
        System.out.println("Book added successfully!");
    }

    @Override
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books registered.");
            return;
        }

        for (Book book : books) {
            System.out.println("-------------------------");
            book.displayBookDetails();
            if (book.getAvailableCopies() == 0) {
                System.out.println("Status: Currently unavailable");
            }
        }
        System.out.println("-------------------------");
        System.out.println("Total books registered: " + books.size());
    }

    public void searchBook(int bookId) {
        Book book = bookMap.get(bookId);
        if (book == null) {
            System.out.println("Book not found.");
        } else {
            book.displayBookDetails();
        }
    }

    public int registerStudent(String name, String contact, String department, int year) {
        int id = nextMemberId++;
        members.add(new Student(id, name, contact, department, year));
        System.out.println("Student registered. Member ID: " + id);
        return id;
    }

    public int registerFaculty(String name, String contact, String department, String designation) {
        int id = nextMemberId++;
        members.add(new Faculty(id, name, contact, department, designation));
        System.out.println("Faculty registered. Member ID: " + id);
        return id;
    }

    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        for (LibraryMember member : members) {
            member.displayMemberDetails(); // Runtime polymorphism
        }
    }

    public void searchMember(int memberId) {
        LibraryMember member = findMember(memberId);
        if (member == null) {
            System.out.println("Member not found.");
        } else {
            member.displayMemberDetails();
        }
    }

    private LibraryMember findMember(int memberId) {
        for (LibraryMember member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }

    @Override
    public void issueBook(int bookId, int memberId) {
        Book book = bookMap.get(bookId);
        LibraryMember member = findMember(memberId);

        if (member == null) {
            System.out.println("Member ID does not exist.");
            return;
        }
        if (book == null) {
            System.out.println("Book ID does not exist.");
            return;
        }
        if (book.getAvailableCopies() <= 0) {
            System.out.println("No copies available.");
            return;
        }

        book.setAvailableCopies(book.getAvailableCopies() - 1);
        IssueRecord record = new IssueRecord(nextIssueId++, bookId, memberId);
        issueRecords.put(record.getIssueId(), record);
        issuedBookIds.add(bookId);

        System.out.println("Book issued successfully!");
        System.out.println("Member: " + member.getMemberName());
        System.out.println("Book: " + book.getBookName());
        System.out.println("Available copies: " + book.getAvailableCopies());
    }

    @Override
    public void returnBook(int bookId, int memberId) {
        Book book = bookMap.get(bookId);
        if (book == null) {
            System.out.println("Book ID does not exist.");
            return;
        }
        if (findMember(memberId) == null) {
            System.out.println("Member ID does not exist.");
            return;
        }

        IssueRecord activeRecord = null;
        for (IssueRecord record : issueRecords.values()) {
            if (record.getBookId() == bookId
                    && record.getMemberId() == memberId
                    && record.isActive()) {
                activeRecord = record;
                break;
            }
        }

        if (activeRecord == null) {
            System.out.println("No active issue record found for this member and book.");
            return;
        }

        activeRecord.markReturned();
        book.setAvailableCopies(book.getAvailableCopies() + 1);

        boolean anotherActiveIssue = false;
        for (IssueRecord record : issueRecords.values()) {
            if (record.getBookId() == bookId && record.isActive()) {
                anotherActiveIssue = true;
                break;
            }
        }
        if (!anotherActiveIssue) {
            issuedBookIds.remove(bookId);
        }

        System.out.println("Book returned successfully!");
        System.out.println("Book: " + book.getBookName());
        System.out.println("Available copies: " + book.getAvailableCopies());
    }

    public void displayIssuedBooks(boolean activeOnly) {
        if (issueRecords.isEmpty()) {
            System.out.println("No issue records available.");
            return;
        }

        boolean found = false;
        for (IssueRecord record : issueRecords.values()) {
            if (activeOnly && !record.isActive()) {
                continue;
            }
            found = true;
            Book book = bookMap.get(record.getBookId());
            LibraryMember member = findMember(record.getMemberId());

            System.out.println("-------------------------");
            System.out.println("Issue ID: " + record.getIssueId());
            System.out.println("Member ID: " + record.getMemberId()
                    + (member == null ? "" : " (" + member.getMemberName() + ")"));
            System.out.println("Book ID: " + record.getBookId()
                    + (book == null ? "" : " (" + book.getBookName() + ")"));
            System.out.println("Status: " + (record.isActive() ? "Active" : "Returned"));
        }
        if (!found) {
            System.out.println("No active issue records.");
        }
    }

    public void generateReport() {
        int totalCopies = 0;
        int activeIssues = 0;

        for (Book book : books) {
            totalCopies += book.getAvailableCopies();
        }
        for (IssueRecord record : issueRecords.values()) {
            if (record.isActive()) {
                activeIssues++;
            }
        }

        System.out.println("\\n========== LIBRARY REPORT ==========");
        System.out.println("Total books registered: " + books.size());
        System.out.println("Total registered members: " + members.size());
        System.out.println("Total active issue records: " + activeIssues);
        System.out.println("Total available book copies: " + totalCopies);
        System.out.println("Books currently unavailable:");

        boolean unavailableFound = false;
        for (Book book : books) {
            if (book.getAvailableCopies() == 0) {
                System.out.println(book.getBookId() + " - " + book.getBookName());
                unavailableFound = true;
            }
        }
        if (!unavailableFound) {
            System.out.println("None");
        }
        System.out.println("=====================================");
    }
}
