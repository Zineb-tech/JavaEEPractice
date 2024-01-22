package dao;

import Model.Books;
import Model.Student;

public interface issueDao {

	Books getBookDetailById(int IdBook);
	Student getStudentDetailById(int idStudent) ;


}
