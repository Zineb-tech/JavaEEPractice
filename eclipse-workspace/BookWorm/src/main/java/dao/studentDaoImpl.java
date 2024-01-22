package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import Model.Student;

public class studentDaoImpl implements studentDao {
    PreparedStatement ps;
    Connection con;
	ResultSet rs;
	Student student;
	
	public studentDaoImpl() {
		super();
		con=extra.db.database.getConnected();

	}

	public void addStudent(Student student) {
		
		try {
			
			ps=con.prepareStatement("INSERT INTO students Values(?,?,?,?)");
			ps.setInt(1, student.getIdStudent());
			ps.setString(2, student.getStudentName());
			ps.setString(3, student.getCourseName());
			ps.setString(4, student.getBranchName());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	public List<Student> getAllStudent() {
		List<Student> studentList= new ArrayList<>();
		try {
			ps=con.prepareStatement("Select * FROM students");
			rs=ps.executeQuery();
			while(rs.next()) {
				 student=new Student(rs.getInt("studentId"),rs.getString("studentName"),rs.getString("courseName"),rs.getString("branchName"));
				studentList.add(student);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;

	}
}
