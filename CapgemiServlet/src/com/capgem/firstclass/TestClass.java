package com.capgem.firstclass;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/o")
public class TestClass extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		PrintWriter out =  resp.getWriter();
		resp.setContentType("text/html");
		
		RequestDispatcher dis= req.getRequestDispatcher("/header.html");
	     dis.include(req, resp);
				
		
		
		String eid= req.getParameter("id");
		String pass = req.getParameter("password");
		
		ResultSet rs=null;
		Connection  con =null;
		PreparedStatement pstmt=null;
		
		try {
			java.sql.Driver driver= (java.sql.Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			
			//
			String dburl="jdbc:mysql://localhost:3306/Avengers?";
			con=DriverManager.getConnection(dburl,eid,pass);
			
			
			//
			String query="select * from marvel_table";
			pstmt=con.prepareStatement(query);
			
			
			rs=pstmt.executeQuery();
			
			
			
			
			while(rs.next()) {
			
				int id1= rs.getInt("a_id");
				String name= rs.getString("a_name");
				String power=rs.getString("a_power");
				String planet=rs.getString("a_planet");
				
				out.print("<table border=1 cellspacing=1px cellpadding=20px>"
						+ "<tr>"
						+"<th>"
						+"a_id"+"</th>"
						+"<th>"+"a_name"+"</th>"
						+"<th>"+"a_power"+"</th>"
						+"<th>"+"a_planet"+"</th>"
						+"</tr>"
						+"<tr>"+"<td>"+id1+"</td>"
						+"<td>"+name+"</td>"
						+"<td>"+power+"</td>"
						+"<td>"+planet+"</td>"+"</tr>"
						);
				
				
			
				}
			
			
			
			
		} catch (Exception e) {
			out.print("incorrect password or usrname");
			e.printStackTrace();
		} finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
	}

}
