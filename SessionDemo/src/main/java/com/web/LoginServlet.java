package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		
		if(user.equals("saa") && pwd.equals("Sneha")) {
			HttpSession session=request.getSession();
			session.setAttribute("user", "Shrey");
			session.setMaxInactiveInterval(30*60);
			response.sendRedirect("LoginSuccess.jsp");
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("/login.html");
			PrintWriter out=response.getWriter();
			out.println("<font color=red> Either username or password is wrong.</font>");
			rd.include(request, response);
		}
	}

}
