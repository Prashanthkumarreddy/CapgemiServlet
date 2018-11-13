package com.capgem.firstclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckMethod extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		PrintWriter out =  resp.getWriter();
		resp.setContentType("text/html");
		
		
		String method= req.getMethod();
		StringBuffer url = req.getRequestURL();
		String protocol = req.getProtocol();
		
		out.print("<h1>"+method+"</h1>");
		out.print("<h2>"+url+"</h2>");
		out.print(protocol);
		
		System.out.println(method);
		System.out.println(url);
		System.out.println(protocol);
		
	}

}
