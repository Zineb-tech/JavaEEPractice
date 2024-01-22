package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Student;
import dao.studentDaoImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       studentDaoImpl studentImp;
		  Student student;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   int studentId= Integer.parseInt(request.getParameter("studentId"));
		   String studentName=request.getParameter("studentName");
		   String courseName= request.getParameter("courseName");
		   String branchName= request.getParameter("branchName");
		   Student student= new Student(studentId,studentName,courseName,branchName);
	       studentDaoImpl studentImp=new studentDaoImpl();
	       studentImp.addStudent(student);
	       request.getRequestDispatcher("Student.jsp").forward(request, response);


	}

}
