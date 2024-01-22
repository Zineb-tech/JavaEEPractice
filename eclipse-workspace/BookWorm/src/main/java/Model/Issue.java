package Model;

public class Issue {

	
	int idBook;
	int idStudent;
	String IssueDate;
	String DueDate;
	
	public Issue(int idBook, int idStudent, String issueDate, String dueDate) {
		super();
		this.idBook = idBook;
		this.idStudent = idStudent;
		IssueDate = issueDate;
		DueDate = dueDate;
	}
	public int getIdBook() {
		return idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public String getIssueDate() {
		return IssueDate;
	}
	public void setIssueDate(String issueDate) {
		IssueDate = issueDate;
	}
	public String getDueDate() {
		return DueDate;
	}
	public void setDueDate(String dueDate) {
		DueDate = dueDate;
	}
	
}
