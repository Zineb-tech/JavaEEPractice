package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Books;

public class bookDaoImpl implements bookDao {
    private static final Logger LOGGER = Logger.getLogger(bookDaoImpl.class.getName());

    public Connection con;
    public Books book;
    public PreparedStatement ps;
    public ResultSet rs;

    public bookDaoImpl() {
        con = extra.db.database.getConnected();
    }

    public Books addBook(Books book) {
        try {
            ps = con.prepareStatement("INSERT INTO books VALUES (?,?,?,?)");
            ps.setInt(1, book.getBookId());
            ps.setString(2, book.getBookName());
            ps.setString(3, book.getAuthorName());
            ps.setInt(4, book.getQuantity());
            ps.executeUpdate();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error adding book", e);
            return null;

        }
		return book;
    }

    public List<Books> getAllBooks() {
        List<Books> bookList = new ArrayList<>();
        try {
            ps = con.prepareStatement("SELECT * FROM books");
            rs = ps.executeQuery();
            while (rs.next()) {
                book = new Books(rs.getInt("BookId"), rs.getString("bookName"), rs.getString("authorName"),
                        rs.getInt("Quantity"));
                bookList.add(book);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error retrieving all books", e);
        }
        return bookList;
    }
  

    
   
    
   
}
