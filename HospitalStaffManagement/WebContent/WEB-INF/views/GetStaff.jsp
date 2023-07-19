<%@page import="com.oop.model.Staff"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "CSS\staff.css" />

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Staff s1 = (Staff) request.getAttribute("s1");
	%>
<div class="staffreg">
	<form method="POST" action="UpdateStaff">
	
	<center> <h2> UPDATE / DELETE STAFFS </h2></center> <br>
	
		<table>
			<tr>
				<td>Staff ID</td>
				<td><input type="text" name="StaffID" disabled="disabled" value="<%=s1.getStaffID()%>" /></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="FirstName" value="<%=s1.getFirstName()%>" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="LastName" value="<%=s1.getLastName()%>" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="Address" value="<%=s1.getAddress()%>" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="Age" value="<%=s1.getAge()%>" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="Email" value="<%=s1.getEmail()%>" /></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><input type="text" name="Role" value="<%=s1.getRole()%>" /></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="Salary" value="<%=s1.getSalary()%>" /></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="hidden" name="StaffID" value="<%=s1.getStaffID()%>" /> 
				<input type="submit" value="Update Staff"/>
				</td>
			</tr>
		</table>
	</form>

	<form method="POST" action="DeleteStaff">
	<table>
		<tr>
			<td colspan="2">
				<!--  <form method="POST" action="DeleteStaff"> -->
					<input type="hidden" name="StaffID" value="<%=s1.getStaffID()%>" /> 
					<input id="redbtn" type="submit" value="Delete Staff"/>
				<!--  </form> -->
			</td>
		</tr>
	</table>
	</form>
 </div>	
</body>
</html>