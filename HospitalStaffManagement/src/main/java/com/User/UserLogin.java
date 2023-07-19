package com.User;

import javax.servlet.DispatcherType;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import java.sql.*;



@WebServlet("/login")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get form values and assign it to the variables
		String uname = request.getParameter("uname") ;
		String pass = request.getParameter("pass") ;
		String utype = request.getParameter("user-type");
		
		//creating objects and initialize it
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		
		Connection conn = null;
		
		try {
			//register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish the Database connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/staffmanagement","root","Vithya24");
			
			//creating sql query
			PreparedStatement pst = conn.prepareStatement("select * from user where uname = ? and password = ? and utype = ?");
			pst.setString(1, uname);
			pst.setString(2, pass);
			pst.setString(3, utype);
			
			//execeute the query
			ResultSet result = pst.executeQuery();
			
			if (result.next()) {
				
				if(utype.equals("doctor")) {
					//create session attributes set values
					session.setAttribute("name", result.getString("name"));
					session.setAttribute("uname", result.getString("uname"));
					session.setAttribute("password", result.getString("password"));
					rd = request.getRequestDispatcher("#");
				}
				if(utype.equals("patient")) {
					//create session attributes set values
					session.setAttribute("name", result.getString("name"));
					session.setAttribute("uname", result.getString("uname"));
					session.setAttribute("password", result.getString("password"));
					rd = request.getRequestDispatcher("#");
				}
				if (utype.equals("admin")) {
					//create session attributes set values
					session.setAttribute("name", result.getString("name"));
					session.setAttribute("uname", result.getString("uname"));
					session.setAttribute("password", result.getString("password"));
					rd = request.getRequestDispatcher("Admin.jsp");
				}
				if(utype.equals("receptionist")) {
					//create session attributes set values
					session.setAttribute("name", result.getString("name"));
					session.setAttribute("uname", result.getString("uname"));
					session.setAttribute("password", result.getString("password"));
					rd = request.getRequestDispatcher("#");
				}
				
			}
			else {
				//redirect to loginValid page
				rd = request.getRequestDispatcher("loginValid.jsp");
			}
			//forward the request and response
			rd.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
