package combookapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import combookapp.dao.Book;
import combookapp.dao.BookDao;
import combookapp.dao.BookDaoImplMap;

@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BookDao bookDao=new BookDaoImplMap();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> books=bookDao.getAll();
		request.setAttribute("books", books);
		RequestDispatcher rd=request.getRequestDispatcher("show.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn=request.getParameter("isbn");
		String title=request.getParameter("title");
		double price=Double.parseDouble(request.getParameter("price"));
		Book book=new Book(isbn, title, price);
		bookDao.addBook(book);
		response.sendRedirect("BookController");
		
	}

}
