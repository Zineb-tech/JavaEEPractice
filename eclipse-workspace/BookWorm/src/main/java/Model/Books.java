package Model;

public class Books {
	int BookId;
	String bookName;
	String authorName;
	int Quantity;
    boolean available=true;

	
	
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(int bookId, String bookName, String authorName, int quantity) {
		super();
		BookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		Quantity = quantity;
	}
	
	public boolean isAvailable() {
		
		if (this.Quantity>0)
		return available;
		else return !available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public int getBookId() {
		return BookId;
	}
	public void setBookId(int bookId) {
		BookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

}
