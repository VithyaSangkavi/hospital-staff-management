<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <link rel="stylesheet" href="assets/css/maicons.css">

  <link rel="stylesheet" href="assets/css/bootstrap.css">

  <link rel="stylesheet" href="assets/vendor/owl-carousel/css/owl.carousel.css">

  <link rel="stylesheet" href="assets/vendor/animate/animate.css">

  <link rel="stylesheet" href="assets/css/theme.css">
<title>Login</title>
</head>
<body>

	  <div class="page-section">
    <div class="container">
      <h1 class="text-center wow fadeInUp">Login</h1>

      <form action="login" method="post" class="main-form">
        <div class="row mt-5 ">
          
            <input type="text" class="form-control" name = "uname" placeholder="Username" required>
         
          <br><br><br>
          
          
            <select name="user-type" id="user-type" class="custom-select" required>
              <option value="" id="default" disabled selected>Select User Type</option>
              <option value="admin">Admin</option>
              <option value="patient">Patient</option>
              <option value="receptionist">Receptionist</option>
              <option value="doctor">Doctor</option>
            </select>
            
            <br><br><br>
            
             <input type="password" class="form-control" name="pass" placeholder="Password" required>
             
             <br><br><br>
        
        </div>
        
		<div class = "login_Btn">
        <button type="submit" class="btn btn-primary mt-3 wow zoomIn">Login</button>
      	
      	<a href = "#" class="btn btn-primary mt-3 wow zoomIn" >Create new Account</a>
      	
      	<a href = "#" class="btn btn-outline-accent mt-3 wow zoomIn" >Forgot Password ?</a>
      	
      	<a href = "index.jsp" class="btn col-12 btn-primary mt-3 wow zoomIn" >Back to home page</a>
      	</div>
      </form>
    </div>
  </div> 

</body>
</html>