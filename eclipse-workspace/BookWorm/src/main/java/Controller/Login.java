package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userDaoImpl;


/**
 * Servlet implementation class Login
 */
@WebServlet({"/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private userDaoImpl userDAOImpl;
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
	    userDAOImpl = new userDaoImpl();
	}

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher rd ;
		rd = request.getRequestDispatcher("SignUp.jsp");	
		rd.forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String email=  request.getParameter("user");
		String password=  request.getParameter("pass");

		
		int x=userDAOImpl.verifylogin(email, password);
		RequestDispatcher rd;
		if(x==1) {
			String user = userDAOImpl.getUsernameByemail(email);
			HttpSession session= request.getSession();			
			session.setAttribute("user", user);
			rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
			
		}
		else if(x==0){
			request.setAttribute("error", "password or email error");
			rd=request.getRequestDispatcher("SignUp.jsp");
			rd.forward(request, response);
		}
		else {
			System.out.println("erreur de connexion");
		}
	}

}
