package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SCEx")
public class ServletContextEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletContextEx() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 현재 이 서블릿이 ..??
		String id = getServletContext().getInitParameter("id");
		String password = getServletContext().getInitParameter("password");
		String local = getServletContext().getInitParameter("local");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("id : " + id + "<br>");
		out.println("password : " + password + "<br>");
		out.println("local : " + local + "<br>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
