package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.*;
import com.oop.service.IStaffService;
import com.oop.service.StaffService;

/**
 * Servlet implementation class UpdateStaff
 */
@WebServlet("/UpdateStaff")
public class UpdateStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	//do post method
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		Staff s1 = new Staff();
		String StaffID = request.getParameter("StaffID");	
		s1.setStaffID(StaffID);
		s1.setFirstName(request.getParameter("FirstName"));
		s1.setLastName(request.getParameter("LastName"));
		s1.setAddress(request.getParameter("Address"));
		s1.setAge(request.getParameter("Age"));
		s1.setEmail(request.getParameter("Email"));
		s1.setRole(request.getParameter("Role"));
		s1.setSalary(Double.parseDouble(request.getParameter("Salary")));
	
		
		IStaffService iss = new StaffService();
		iss.UpdateStaff(StaffID, s1);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListStaff.jsp");
		dispatcher.forward(request, response);
		
	}

}
