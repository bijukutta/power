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
%>
	<table width = "75%" border="1" width="1" cellspacing="1" cellpadding="1">
    <thead>
        <tr>
            <th>SL</th>
            <th> Name</th>
            <th>Description</th>
        </tr>
    </thead>
    <tbody>
<%
	while (rs.next())
		{
		
		%>
                <tr>
                    <td width 20%> <% out.print(rs.getInt(1)); %> </td>
                    <td width 40%> <% out.print(rs.getString(2)); %> </td>
                    <td width 40%> <% out.print(rs.getString(3)); %> </td>
                </tr>
		<%
	}
	%>
    </tbody>
    </table>
	
</body>
</html>
