package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Books;
import Model.Student;
import Model.Issue;

import dao.issueDaoImpl;
import dao.userDaoImpl;

@WebServlet("/IssueServlet")
public class IssueServlet extends HttpServlet {
	issueDaoImpl issueDaoImpl;
    // ... existing code ...
	public void init() throws ServletException {
	    // Instantiate userDAOImpl during servlet initialization
	    issueDaoImpl = new issueDaoImpl();
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ... existing code ...
    	try {
    	 int idBook = Integer.parseInt(request.getParameter("idBook"));
    	 int idStudent = Integer.parseInt(request.getParameter("idStudent"));
    	 String IssueDate= request.getParameter("issueDate");
    	 String DueDate= request.getParameter("dueDate"); 
         Issue issue= new Issue(idBook,idStudent,IssueDate,DueDate);
         issueDaoImpl.addIssue(issue);
     
    	Student student = issueDaoImpl.getStudentDetailById(idStudent);
	   	Books book = issueDaoImpl.getBookDetailById(idBook);

        request.setAttribute("student", student);
        request.setAttribute("book", book);
        
        // Forward the request to the Issue.jsp 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Issue.jsp");
        dispatcher.forward(request, response);}
        catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
    
    
}
