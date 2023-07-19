/**
 * 
 */
  
 
 function validate(){
	
	var pass = document.getElementById("Pass").value;
	var cpass = document.getElementById("Cpass").value;
	
	if(pass != cpass){
		 alert('Password Mismatch , Try Again');
		 return false;
	}
	else if (pass.length < 4){
		 alert('Password length should be higher than 4 , Try Again');
		 return false;
	}
	else if (pass.length > 8){
		 alert('Password length should be less than 8, Try Again');
		 return false;
	}
	else{
		true;
	}
}

function samePass(){
	
	var pass = document.getElementById("cPass").value;
	var cpass = document.getElementById("nPass").value;

	

	if (cpass.length < 4){
		 alert('Password length should be higher than 4 , Try Again');
		 return false;
	}
	else if (cpass.length > 8){
		 alert('Password length should be less than 8, Try Again');
		 return false;
	}
	else{
		alert("New password is same as Current Password !!!");
		 return true;
	}
}

