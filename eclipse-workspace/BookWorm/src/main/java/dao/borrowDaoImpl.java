package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Books;
import Model.Student;

public class borrowDaoImpl implements borrowDao{
	 public Connection con;
	    public Books book;
	    public Student student;
	    public PreparedStatement ps;
	    public ResultSet rs;
	    
	    
	    public borrowDaoImpl() {
			super();
			// TODO Auto-generated constructor stub
			con=extra.db.database.getConnected();

		}

		public void borrowBook(int bookId ,int studentId ) {
	    	try {
				ps=con.prepareStatement("Insert into loans values (?,?)");
				ps.setInt(1, bookId);
				ps.setInt(2, studentId);
			    ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	    
	    public void updateBookQuantity(int BookId) {
	        try {
	        	int currentQuantity= getBookQuantity(BookId);
	            // Update the book quantity in the 'books' table
	        	if (currentQuantity>0) {
	            ps = con.prepareStatement("UPDATE books SET Quantity = Quantity - 1 WHERE BookId = ?");
	            ps.setInt(1, BookId);
	            ps.executeUpdate();}
	            else System.out.println("No more available");
	        } catch (Exception e) {
				e.printStackTrace();

	        }
	    }

		private int getBookQuantity(int bookId) {
			// TODO Auto-generated method stub
			try {
				ps= con.prepareStatement("SELECT Quantity from books WHERE BookId = ? ");
				ps.setInt(1, bookId);
				rs=ps.executeQuery();
				if(rs.next()) {
					return rs.getInt("Quantity");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}	    
}
