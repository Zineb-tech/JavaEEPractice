package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Books;
import dao.bookDaoImpl;
/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	bookDaoImpl bookimp;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        bookimp = new bookDaoImpl();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int BookId= Integer.parseInt(request.getParameter("idBook"));
		String bookName=request.getParameter("bookName");
		String authorName=request.getParameter("authorName");
		int Quantity=Integer.parseInt(request.getParameter("quantity"));		
		Books book= new Books(BookId,bookName,authorName,Quantity);
        bookimp.addBook(book);
        request.getRequestDispatcher("Book.jsp").forward(request, response);

	}

}
