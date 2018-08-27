package lu.lllc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection;
		PreparedStatement statement;
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));
		
		String dbURL = DBInfo.getDBURL();
		String user = DBInfo.getUser();
		String password = DBInfo.getPassword();

			Class.forName(DBInfo.getDriver());
			connection = DriverManager.getConnection(dbURL, user, password);
			statement = connection.prepareStatement("INSERT INTO products (id, title, description, price) VALUES (0,?,?,?)");
			statement.setString(1,title);
			statement.setString(2, description);
			statement.setFloat(3, price);		
			statement.executeUpdate();
			connection.close();
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/addingOk.jsp");
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
