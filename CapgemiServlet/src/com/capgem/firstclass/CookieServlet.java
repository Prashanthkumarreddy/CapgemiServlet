package com.capgem.firstclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/cookie")
public class CookieServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		Cookie ref1= new Cookie("user", "root");
		ref1.setMaxAge(60*60*24*7);
	resp.addCookie(ref1);
		
	
		out.println("hellloo cookie");
		
		
//	Cookie [] rcvdCookie = req.getCookies();
//		for (Cookie c:rcvdCookie){
//			
//			
//						out.print("<h3> cookie name:</h3>"+c.getName());
//			out.print("<h3> cookievalue:</h3>"+c.getValue());			
//		}
//		
		
		
		
		
		
		
		
	}

}
