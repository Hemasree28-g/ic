public class IssueRecord {
    private int issueId;
    private int bookId;
    private int memberId;
    private boolean active;

    public IssueRecord(int issueId, int bookId, int memberId) {
        this.issueId = issueId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.active = true;
    }

    public int getIssueId() { return issueId; }
    public int getBookId() { return bookId; }
    public int getMemberId() { return memberId; }
    public boolean isActive() { return active; }

    public void markReturned() {
        active = false;
    }
}
