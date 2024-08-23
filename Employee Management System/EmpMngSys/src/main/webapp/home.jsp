<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Data</title>

<style>
	*{
		text-align:center;
		text-decoration: none;
	}
</style>

</head>
<body>
	
	<h3><%= session.getAttribute("email") %></h3>
	<h3><%= session.getAttribute("pwd") %></h3>

	<a href="SignUp.jsp"><button style="display: block; margin: auto">Create new record</button></a>
	<table align="center" cellspacing="10" border="5" height="500" width="500" style="border-collapse: collapse;">
	<tr">
		<th>ID</th>
		<th>Name</th>
		<th>Email</th>
		<th>Password</th>
		<th>Salary</th>
		<th colspan=2>Action</th>
	</tr>
	<%
		ResultSet rs=(ResultSet) request.getAttribute("res");
		while(rs.next())
		{
			%>
			<tr>
				<td><%=rs.getInt(1)%></td>
				<td><%=rs.getString(2)%></td>
				<td><%=rs.getString(3)%></td>
				<td><%=rs.getString(4)%></td>
				<td><%=rs.getInt(5)%></td>
				<td><a href="update?id=<%=rs.getInt(1)%>"><button>Update</button></a></td>
				<td><a href="delete?id=<%=rs.getInt(1)%>"><button>Delete</button></a></td>
			</tr>
		<%	
		}
	%>
	</table>
	<a href="logout"> <button>Logout</button> </a>
</body>
</html>