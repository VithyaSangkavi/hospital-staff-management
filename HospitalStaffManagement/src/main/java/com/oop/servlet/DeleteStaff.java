package com.oop.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.IStaffService;
import com.oop.service.StaffService;


/**
 * Servlet implementation class DeleteStaff
 */
@WebServlet("/DeleteStaff")
public class DeleteStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStaff() {
        super();
        // TODO Auto-generated constructor stub
    }

    //do post method
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		String StaffID = request.getParameter("StaffID");			
		
		
		IStaffService iss = new StaffService();
		iss.RemoveStaff(StaffID);
		
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListStaff.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
