<%-- 
    Document   : login
    Created on : Aug 27, 2018, 11:34:30 AM
    Author     : dad
--%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.*,javax.servlet.http.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
       
        <%
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://jws-app-mysql:3306/llc","user","password");
                    //Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/llc","root","root");
                    PreparedStatement ps=con.prepareStatement("SELECT * from products");
                    ResultSet rs=ps.executeQuery();
                    while (rs.next())
                    {
                        out.print(rs.getString(2));
                    }

            %>
    </body>
</html>
