package com.capgem.firstclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateProfileServ extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int eid = Integer.parseInt(req.getParameter("empid"));
		String ename = req.getParameter("name");
		int sal = Integer.parseInt(req.getParameter("sal"));
		int mgr= Integer.parseInt(req.getParameter("mgr"));
		String dept = req.getParameter("dpt");
		String pass = req.getParameter("pwd");
		String city=req.getParameter("city");
		String desig=req.getParameter("desig");
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		Connection con =null;
		PreparedStatement pstmt=null;
		
		
		try {
			java.sql.Driver driver=(java.sql.Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
		
			
			String url="jdbc:mysql://localhost:3306/Avengers?user=j2ee&password=1234";
			con=DriverManager.getConnection(url);
			
			String query="insert into employee_table values(?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, eid);
			pstmt.setString(2,ename);
			pstmt.setString(3,dept);
			pstmt.setInt(4,sal);
			pstmt.setInt(5,mgr);
			pstmt.setString(6, desig);
			pstmt.setString(7, city);
			pstmt.setString(8,pass);
			
			int count=pstmt.executeUpdate();
			
			if(count>0) {
				out.println("data inserted");
				System.out.println("data inserted");
			}
			else {
				out.println("failed");
				System.out.println("failed");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
