<%@page import="com.oop.model.Staff"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.StaffService"%>
<%@page import="com.oop.service.IStaffService"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

<link rel = "stylesheet"
   type = "text/css"
   href = "CSS\staff.css" />

<meta charset="ISO-8859-1">
<title>Hospital Staff Management</title>
</head>
<body>
<div class = "list">
	
	<table cellpadding="12">
			 <caption><h2>LIST OF STAFFS</h2>
			 <a id="greenbtn" href="index.jsp">Back To HomePage</a>
			 <a id="greenbtn" href="home.jsp">Add Staffs</a>
			 </caption>
			 
			  <tr>
	                <th>Staff ID</th>
	                <th>First Name</th>
	                <th>Last Name</th>
	                <th>Address</th>
	                <th>Age</th>
	                <th>Email</th>
	                <th>Role</th>
	                <th>Salary</th>
	                <th>Select</th>
	            </tr>
	            <%
	            IStaffService iss = new StaffService();
				ArrayList<Staff> arrayList = iss.getStaffs();
				
				for(Staff s1 : arrayList){
				%>
				 <tr>
					<td> <%=s1.getStaffID() %> </td>
					<td> <%=s1.getFirstName() %> </td>
					<td> <%=s1.getLastName() %> </td>
					<td> <%=s1.getAddress() %> </td>
					<td> <%=s1.getAge() %> </td>
					<td> <%=s1.getEmail() %> </td>
					<td> <%=s1.getRole() %> </td>
					<td> <%=s1.getSalary() %> </td>	
					<td> 
					<form method="POST" action="GetStaff">
					<input type="hidden" name="StaffID" value="<%=s1.getStaffID()%>"/>
					<input type="submit" value= "Select Staff" /> 
					</form>
					</td>	
					</tr>			
				<%	
				   }
	            %>     
	</table>

</div>
</body>
</html>