package org.jsp.EmpMngSys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		System.out.println(session.getAttribute("email"));
		System.out.println(session.getAttribute("password")); 
	
		session.invalidate();
	
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>Logout Successfull...</h1>");
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.include(req, resp);
		
	}
	
	
	
	
}	
