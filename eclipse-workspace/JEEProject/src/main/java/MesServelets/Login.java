package MesServelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DataBaseConnection;

/**
 * Servlet implementation class Login
 */
@WebServlet({ "/login", "/Login" })
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DataBaseConnection.getConnected();
        int x = DataBaseConnection.verifyLogin(email, password);

        if (x == 1) {
            
                    String fullName = DataBaseConnection.getUserNameByEmail(email);
                    HttpSession session = request.getSession();
                    session.setAttribute("fullName", fullName);
                    response.sendRedirect("index.jsp");
                } 
        else {
        	
        }
        
        System.out.println("x = " + x);
        System.out.println("login = " + email);
        System.out.println("password = " + password);
    }

    // Other methods...
}
