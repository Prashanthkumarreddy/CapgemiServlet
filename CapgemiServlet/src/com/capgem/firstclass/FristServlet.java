package com.capgem.firstclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FristServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<h1>"+new Date()+"</h1>");
		out.println("<h2> this is dynamic page </h2>");
		
//		ServletConfig config=  getServletConfig();
//		ServletContext contxt=config.getServletContext();
//		
//		out.println(contxt.getInitParameter("email"));
//		
	}

}
