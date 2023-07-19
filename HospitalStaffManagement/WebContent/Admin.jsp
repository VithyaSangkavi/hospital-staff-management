<%@page import="java.io.PrintWriter , java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 
	
	session = request.getSession();
	
	String name="";
	
	String uname = "";
	
	String pass ="";
	
	name = (String)session.getAttribute("name");
	uname = (String)session.getAttribute("uname");
	pass = (String)session.getAttribute("password");
	
   	
   	 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="assets/css/maicons.css">

  <link rel="stylesheet" href="assets/css/bootstrap.css">

  <link rel="stylesheet" href="assets/vendor/owl-carousel/css/owl.carousel.css">

  <link rel="stylesheet" href="assets/vendor/animate/animate.css">

  <link rel="stylesheet" href="assets/css/theme.css">

<title>Welcome <% 	out.println(name); %></title>
</head>
<body>

		<%
		//retreive data && make connection to db
		session = request.getSession();
		RequestDispatcher rd = null;
		
		Connection conn;
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/staffmanagement","root","Vithya24");
			PreparedStatement pst = conn.prepareStatement("select * from user where uname = '"+uname+"' and password = '"+pass+"'");
			
			ResultSet result = pst.executeQuery();
			
			String Name = "";
			String Uname = "";
			String Pass = "";
			String dob = "";
			String Utype = "";
			String phone = "";
			String secQuest = "";
			String answer = "";
			
			
			if(result.next()){
				Name = result.getString("name");
				Uname = result.getString("uname");
				Pass = result.getString("password");
				dob = result.getString("dob");
				Utype = result.getString("utype");
				phone = result.getString("phone");
				secQuest = result.getString("secQuest");
				answer = result.getString("answer");
			}
	
	
	%>
	
		  <div class="page-section">
    <div class="container">
      <h1 class="text-center wow fadeInUp">Welcome <% 	out.println(name); %> !</h1>
      <form class="main-form" action="deleteAcc" method="post">
        <div class="row mt-5 ">
          <div class="col-12 col-sm-6 py-2 wow fadeInLeft">
          	<h5 class = "text-left wow fadeInUp">Full Name</h5>
            <input type="text" class="form-control" name="name" value="<% out.print(Name); %>" placeholder="Full name" disabled>
            
          </div>
          <div class="col-12 col-sm-6 py-2 wow fadeInRight">
          <h5 class = "text-right wow fadeInUp">User Name</h5>
            <input type="text" class="form-control" name="uname" value="<% out.print(Uname); %>" placeholder="User name" disabled>
          </div>
          <div class="col-12 col-sm-6 py-2 wow fadeInLeft">
          <h5 class = "text-left wow fadeInUp">Password</h5>
            <input type="text" class="form-control" name="pass" value="<% out.print(Pass); %>" placeholder="Password" disabled>
          </div>
          <div class="col-12 col-sm-6 py-2 wow fadeInRight">
          <h5 class = "text-right wow fadeInUp">User Type</h5>
            <input type="text" class="form-control" name="utype" value="<% out.print(Utype); %>" placeholder="Utype" disabled>
          </div>
          <div class="col-12 col-sm-6 py-2 wow fadeInLeft" data-wow-delay="300ms">
          <h5 class = "text-left wow fadeInUp">Date Of Birth</h5>
            <input type="text" class="form-control" name="dob" value="<% out.print(dob); %>" disabled>
          </div>
          <div class="col-12 col-sm-6 py-2 wow fadeInRight" data-wow-delay="300ms">
          <h5 class = "text-right wow fadeInUp">Contact No</h5>
            <input type="text" class="form-control" name="phone"  value="<% out.print(phone); %>" placeholder="Phone Number" disabled>
          </div>
          <div class="col-12 py-2 wow fadeInUp" data-wow-delay="300ms">
          <h5 class = "text-center wow fadeInUp">Security Question</h5>
            <input type="text" class="form-control" name="secQuest"  value="<% out.print(secQuest); %>" placeholder="Question" disabled>
          </div>
          <div class="col-12 py-2 wow fadeInUp">
          <h5 class = "text-center wow fadeInUp">Answer</h5>
            <input type="text" class="form-control" name="answer" value="<% out.print(answer); %>" placeholder="Enter your answer ..." disabled>
          </div>

        </div>
       <div class = "login_Btn">
        <div class = " col-12 wow btn ">
        <a href = "Login.jsp" class=" btn btn-primary mt-3 wow zoomIn" >Log Out</a>
      	
      	<a href = "#" class="btn btn-primary mt-3 wow zoomIn" >Edit Details</a>
      	</div>
      	<a href = "home.jsp" class="btn col-12 btn-primary mt-3 wow zoomIn" >Staff Management</a>
      	
      	<a href = "index.jsp" class="btn col-12 btn-primary mt-3 wow zoomIn" >Back to Home Page</a>
      	<button type="submit" class="btn col-12 btn-outline-accent  mt-3 wow zoomIn">Delete</button>
      	</div>
      	</form>
      	</div>
      	</div>

</body>
</html>