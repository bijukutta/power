<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.*,javax.servlet.http.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<h1> List Table by Simple JSP</h1>
<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://jws-app-mysql:3306/llc","user","password");
	PreparedStatement ps=con.prepareStatement("SELECT * FROM products");
	ResultSet rs=ps.executeQuery();
	while (rs.next())
		{
		
		%>
			<%= out.print(rs.getString(3)); %> <br>
		<%
	}
	%>
</body>
</html>
