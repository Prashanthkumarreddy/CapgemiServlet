package com.capgem.firstclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Query extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		
		String a= req.getParameter("firstname");
		String b= req.getParameter("lastname");
		
		
		out.println("<h1><b>"+a+"</b></h1>");
		out.print("<h2>"+b+"</h2>");
		
		System.out.println(a);
		System.out.println(b);
		
	}

	

}
