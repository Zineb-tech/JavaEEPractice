package MesServelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DataBaseConnection;

/**
 * Servlet implementation class Inscription
 */
@WebServlet({ "/Inscription", "/inscription" })

public class Inscription extends HttpServlet {

	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setHeader("Refresh", "0;URL=index.html");

		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		DataBaseConnection.getConnected();



		int existe = DataBaseConnection.exist(email);
        System.out.println("User exists: " + existe);

		if (existe == 1) {
            System.out.println("User already exists. Redirecting to connexion.jsp");

	    	response.sendRedirect("connexion.jsp");
		}else {
			 int creation = DataBaseConnection.createUser(email, fullname, password);
	            System.out.println("User creation result: " + creation);

			if (creation == 1) {
                System.out.println("User created successfully. Redirecting to connexion.jsp");
		    	response.sendRedirect("connexion.jsp");

			}else {
                System.out.println("User creation failed. Redirecting to 404.jsp");

			}
		}
		
		
	}

}
