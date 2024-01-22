package dao;

import java.util.List;

import Model.Student;

public interface studentDao {
	public void addStudent(Student student);
	public List<Student> getAllStudent();


}
