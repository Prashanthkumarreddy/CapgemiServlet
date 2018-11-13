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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServ extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out =resp.getWriter();
		resp.setContentType("text/html");
		int eid= Integer.parseInt(req.getParameter("id"));
		String pass = req.getParameter("password");
		
		RequestDispatcher dis= req.getRequestDispatcher("/header.html");
	     dis.include(req, resp);
		
		//ResultSet rs=null;
		Connection  con =null;
		PreparedStatement pstmt=null;
		
		try {
			java.sql.Driver driver= (java.sql.Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			
			//
			String dburl="jdbc:mysql://localhost:3306/Avengers?user=j2ee&password=1234";
			con=DriverManager.getConnection(dburl);
			
			
			//
			String query="delete from marvel_table where a_id=? and a_power=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,eid );
			pstmt.setString(2, pass);
			
			
			int count=pstmt.executeUpdate();
			
			if(count>0) {
				out.println("row deleted");
			}else {
				out.println("failed");
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			
			}
		}
		
		
		
		
	}
	
	
	
	

