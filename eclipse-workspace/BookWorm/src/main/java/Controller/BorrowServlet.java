package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Borrow;
import dao.borrowDaoImpl;
/**
 * Servlet implementation class BorrowServlet
 */
@WebServlet("/BorrowServlet")
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private borrowDaoImpl borrowDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() throws ServletException {
	    // Initialize borrowDao here
	    this.borrowDao = new borrowDaoImpl();
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
		int bookId= Integer.parseInt( request.getParameter("bookId"));
		int studentId= Integer.parseInt( request.getParameter("studentId"));
		Borrow borrow= new Borrow(bookId,studentId);
		borrowDao.borrowBook(bookId, studentId);
		borrowDao.updateBookQuantity(bookId);
        request.getRequestDispatcher("loanBook.jsp").forward(request, response);

	}

}
