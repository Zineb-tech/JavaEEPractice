package Controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Users;

import dao.userDaoImpl;




@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userDaoImpl userDAOImpl;
	
	
	@Override
	public void init() throws ServletException {
	    // Instantiate userDAOImpl during servlet initialization
	    userDAOImpl = new userDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullname=  request.getParameter("fullname");
		String email= request.getParameter("user");
		String password= request.getParameter("pass");
		
		RequestDispatcher rd ;
		
		/*int exist=database.exist(email);
		if(exist==1) {
			request.setAttribute("error", "already exist");
			rd = request.getRequestDispatcher("register.jsp");
		}
		else {*/
			//int creation= database.createUser(email, fullname, password);
	        Users user = new Users(email, fullname, password);
		    int creation= userDAOImpl.addUser(user);
			if (creation==1) {
				HttpSession session= request.getSession();
				session.setAttribute("user", fullname);
				rd= request.getRequestDispatcher("Home.jsp");
				rd.forward(request, response);

			}
			else {
				request.setAttribute("error", "createUser error");
				rd=request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
			}
		}
	

}
