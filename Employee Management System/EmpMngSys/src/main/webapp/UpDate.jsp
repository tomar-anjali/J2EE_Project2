<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee Data</title>
</head>
<body>
	<h3><%= session.getAttribute("email") %></h3>
	<h3><%= session.getAttribute("password") %></h3>
	

	<% ResultSet rs = (ResultSet) request.getAttribute("res");
	while(rs.next())
		{%>


	<h1>Update Here</h1>
	
	<form action="updateemp" method="post">
		<input type="text" value="<%=rs.getInt(1) %>" name="id" placeholder="Enter id"> 
		<input type="text" value="<%=rs.getString(2) %>" name="name" placeholder="Enter name"> 
		<input type="text" value="<%= rs.getString(3) %>" name="email" placeholder="Enter email"> 
		<input type="text" value="<%= rs.getString(4) %>" name="password" placeholder="Enter pasword"> 
		<input type="text" value="<%= rs.getDouble(5) %>" name="sal" placeholder="Enter salary">
		<button type="submit">Update</button>
	</form>
	
	<%	
		}
	%>
	
</body>
</html>