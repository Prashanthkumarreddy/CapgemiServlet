package com.capgem.firstclass;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServ extends HttpServlet{
	

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out =resp.getWriter();
		resp.setContentType("text/html");
		int eid= Integer.parseInt(req.getParameter("id"));
		String pass = req.getParameter("password");
		
		ResultSet rs=null;
		Connection  con =null;
		PreparedStatement pstmt=null;
		
		try {
			java.sql.Driver driver= (java.sql.Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();
			DriverManager.registerDriver(driver);
			
			//
			String dburl="jdbc:mysql://localhost:3306/Avengers?user=j2ee&password=1234";
			con=DriverManager.getConnection(dburl);
			
			
			//
			String query="select * from employee_table where e_id=? and e_password=?";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,eid );
			pstmt.setString(2, pass);
			
			rs=pstmt.executeQuery();
			
			if(rs!=null) {
				if(rs.next()) {
				int id1= rs.getInt("e_id");
				String name= rs.getString("e_name");
				int sal=rs.getInt("e_sal");
				int mgr=rs.getInt("e_mgr");
				String desig=rs.getString("e_designation");
				String dpt=rs.getString("e_dept");
				String  cit=rs.getString("e_city");
				
				
				
				out.println("employee id    "+id1);
				out.println("employee name  "+name);
				out.println("employee sal   "+sal);
				out.println("employee mgr   "+mgr);
				out.println("designation    "+desig);
				out.println("employee dept  "+dpt);
				out.println("employee city  "+cit);
				}
				else if(true){
					
				}else {
					
					resp.sendRedirect("http://localhost:8008/CapgemiServlet/login.html");
				}
				
			}
			else {
				//resp.sendRedirect("http://localhost:8008/CapgemiServlet/login.html");
			
			}
			
			
		} catch (SQLException e) {
			
		//resp.sendRedirect("http://localhost:8008/CapgemiServlet/login.html");
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
			finally {
		
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
	

