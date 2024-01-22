package dao;

public interface borrowDao {
     void borrowBook(int bookId ,int studentId );
     void updateBookQuantity(int BookId);

}
