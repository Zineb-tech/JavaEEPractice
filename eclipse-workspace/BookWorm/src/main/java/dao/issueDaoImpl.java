package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import Model.Books;
import Model.Issue;
import Model.Student;

public class issueDaoImpl implements issueDao{

	    PreparedStatement ps;
	    Connection con;
		ResultSet rs;
	    Issue issue;
        Student student;
        Books book;
	public issueDaoImpl() {
			super();
			con= extra.db.database.getConnected();
		}


	

	@Override
	public Books getBookDetailById(int idBook) {
		// TODO Auto-generated method stub
		try {
			ps=con.prepareStatement("SELECT * from books where BookId=?");
			ps.setInt(1,idBook);
			rs=ps.executeQuery();
			if(rs.next()) {
				 book=new Books(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				 return book;
			}
			else System.out.println("inexist id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return book;
	}


	public Student getStudentDetailById(int idStudent) {
		
		// TODO Auto-generated method stub
		try {
			ps=con.prepareStatement("SELECT * from students where StudentId=?");
			ps.setInt(1, idStudent);
			rs=ps.executeQuery();
			if(rs.next()) {
				 student=new Student(rs.getInt(1),rs.getString("studentName"),rs.getString("courseName"),rs.getString("branchName"));
				 return student;
			}
			else System.out.println("inexist id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}




	public void addIssue(Issue issue) {
		// TODO Auto-generated method stub
		 try {
	            ps = con.prepareStatement("INSERT INTO issue VALUES (?,?,?,?)");
	            ps.setInt(1, issue.getIdBook());
	            ps.setString(3, issue.getDueDate());
	            ps.setInt(2, issue.getIdStudent());
	            ps.setString(4, issue.getIssueDate());
	            ps.executeUpdate();
	        } catch (Exception e) {
				e.printStackTrace();

	        }
	}
}
