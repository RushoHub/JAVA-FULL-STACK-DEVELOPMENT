package com.simplilearn.loginapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		HttpSession session = request.getSession();
		
		if(name.equals("Rusho") && pwd.equals("admin123"))
		{
			
			session.setAttribute("user", name);
			
			response.sendRedirect("dashboard");
		}
		
		else
		{
			session.setAttribute("wrong", name);
			
			response.sendRedirect("error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
