package org.jsp.EmpMngSys;

import java.io.IOException;
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
@WebServlet(urlPatterns = "/updateemp")
public class UpdateEmpServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		double sal=Double.parseDouble(req.getParameter("sal"));
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/EMS", "postgres", "root");
			PreparedStatement ps = con.prepareStatement("update emp set name=?, email=?, password=?, sal=? where id=?");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setDouble(4, sal);
			ps.setInt(5, id);
			int row = ps.executeUpdate();
			System.out.println(row + " : Row Affectd");
			ps.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/EMS", "postgres", "root");
			PreparedStatement ps = con.prepareStatement("select * from emp order by id asc");
			
			ResultSet rs = ps.executeQuery();
			
			req.setAttribute("res", rs);
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
			ps.close();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
