package Model;

public class Borrow {
	int bookId;
	int studentId;
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Borrow(int bookId, int studentId) {
		super();
		this.bookId = bookId;
		this.studentId = studentId;
	}
    
	
     
}
