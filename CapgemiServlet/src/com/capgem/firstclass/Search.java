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

@WebServlet("/xyz")

public class Search extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter out =resp.getWriter();
	resp.setContentType("text/html");
	int eid= Integer.parseInt(req.getParameter("id"));
	RequestDispatcher dis= req.getRequestDispatcher("/header.html");
     dis.include(req, resp);
	
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
		String query="select * from marvel_table where a_id=?";
		pstmt=con.prepareStatement(query);
		pstmt.setInt(1,eid );
		
		
		rs=pstmt.executeQuery();
		
		if(rs!=null) {
			if(rs.next()) {
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
				
			}else {
				resp.sendRedirect("http://localhost:8008/CapgemiServlet/search.html");
			}
}
	
	
	

}catch(Exception e) {
	
	
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
