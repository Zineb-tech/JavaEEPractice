package Model;

public class Student {
     int idStudent;
     String studentName;
     String courseName;
     String branchName;
     
	public Student() {
		super();
	}
	public Student(int idStudent, String studentName, String courseName, String branchName) {
		super();
		this.idStudent = idStudent;
		this.studentName = studentName;
		this.courseName = courseName;
		this.branchName = branchName;
	}
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
     
     
     
}
