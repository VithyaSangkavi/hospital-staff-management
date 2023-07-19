package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Staff;
import com.oop.service.IStaffService;
import com.oop.service.StaffService;

/**
 * Servlet implementation class GetStaff
 */
@WebServlet("/GetStaff")
public class GetStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetStaff() {
        super();
        // TODO Auto-generated constructor stub
    }

    //do post method
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

 		String StaffID = request.getParameter("StaffID");			
		
 		
 		
 		IStaffService iss = new StaffService();
 		System.out.println("--------"+StaffID) ;
		Staff s1 = iss.getStaffByID(StaffID);
		
		request.setAttribute("s1", s1);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/GetStaff.jsp");
		dispatcher.forward(request, response);
		
	}

}
