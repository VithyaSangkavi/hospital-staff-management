<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	
	<div class="staffreg">
	  	<form method="POST" action="AddStaff">
	  		<center><h2> HOSPITAL STAFF MANAGEMENT </h2></center>
	  		
	  		<br> <br>
	  		
		    <table>

			<tr>
				<td>First Name</td>
				<td><input type="text" name="FirstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="LastName" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="Address" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="Age" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="Email" /></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><input type="text" name="Role" /></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="Salary" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Add Staff" /> </td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" id="redbtn" value="Reset" /></td>
			</tr>
		</table>
	</form>


	<form method="POST" action="ListStaff">
		<table>
			<tr>
				<td colspan="2"><input type="submit" value="List All Staffs" />
				</td>
			</tr>
		</table>
	</form>
  </div>
  
</body>
</html>