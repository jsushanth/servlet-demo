package com.cg;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.core.Dispatcher;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String username=request.getParameter("uname").trim();
		String password=request.getParameter("pwd").trim();
		RequestDispatcher dispatcher=null;
		if(username.length()>3&& password.length()>3) {
			
			request.setAttribute("msg", "transfer");
			request.setAttribute("uname", username);
			
			request.setAttribute("pwd", password);
			System.out.println("in s1 going to s2");
			dispatcher=request.getRequestDispatcher("/Servlet2");
			dispatcher.include(request,response);
			System.out.println("in s1 after req disptacher frwd");
			String msg=(String) request.getAttribute("msg");
			
			
		
		if(msg.equals("success")) {
			dispatcher=request.getRequestDispatcher("/SuccessServlet");
			dispatcher.include(request,response);
		}
		else if(msg.equals("failure")) {
			dispatcher=request.getRequestDispatcher("/ErrorServlet");
			dispatcher.include(request,response);
		}
		else {
			dispatcher=request.getRequestDispatcher("/ErrorServlet");
			dispatcher.include(request, response);
		}
		
	}

}
}
