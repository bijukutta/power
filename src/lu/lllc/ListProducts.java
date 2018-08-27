package lu.lllc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListProducts
 */
@WebServlet("/ListProducts")
public class ListProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListProducts() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Book> bookList = new ArrayList<Book>();
		// Adding the (at this moment empty) bookList to the session
		request.setAttribute("bookList", bookList);

		Connection connection;
		Statement statement;
		ResultSet result = null;

		String dbURL = DBInfo.getDBURL();
		String user = DBInfo.getUser();
		String password = DBInfo.getPassword();
                
                
                
			Class.forName(DBInfo.getDriver());
			connection = DriverManager.getConnection(dbURL, user, password);
			statement = connection.createStatement();
		String searchString = "SELECT * FROM products";
			result = statement.executeQuery(searchString);

		// Now we collect the data from the result in order to display them in
		// JSP

			while (result.next()) {
				Book book = new Book();
				String title = result.getString("title");
				book.setTitle(title);

				String description = result.getString("description");
				book.setDescription(description);

				float price = result.getFloat("price");
				book.setPrice(price);
				bookList.add(book);
			}
			connection.close();

		RequestDispatcher disp = request
				.getRequestDispatcher("/WEB-INF/showBookList.jsp");
		disp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
