/**
 * 
 */
 
 function search(){
	var page = document.getElementById("search").value;
	
	if(page != "Login" || page != "login"){
		alert("Invalid Search");
		return false;
	}
	else{
		return true;
	}
}