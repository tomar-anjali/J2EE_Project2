package org.jsp.EmpMngSys;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/EMS", "postgres", "root");
			PreparedStatement ps=con.prepareStatement("Select * from emp where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				Class.forName("org.postgresql.Driver");
				Connection con1=DriverManager.getConnection("jdbc:postgresql://localhost:5432/EMS", "postgres", "root");
				PreparedStatement ps1=con.prepareStatement("Select * from emp order by id asc");
				ResultSet rs1=ps1.executeQuery();
				
				HttpSession session = req.getSession();
				session.setAttribute("email", rs.getString(3));
				session.setAttribute("pwd", rs.getString(4));
				
				
				req.setAttribute("res", rs1);
				
				RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
				
				ps1.close();
				con1.close();
			}
				
				else {
					PrintWriter pw=resp.getWriter();
					pw.write("<html><body><h1>Invalid Credentials</h1></body></html>");
					RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
					rd.include(req, resp);
				}
			
			ps.close();
			con.close();
				
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
