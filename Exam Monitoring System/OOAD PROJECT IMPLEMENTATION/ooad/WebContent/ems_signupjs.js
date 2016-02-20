function validator() {
	var f_name=document.getElementById("first_name").value;
	var l_name=document.getElementById("last_name").value;
	var namepattern=/^[a-zA-z.\s]+$/i;
	if(!namepattern.test(f_name)) {
		document.getElementById("error1").innerHTML="Invalid name";
		return false;
	}
	else {
		document.getElementById("error1").innerHTML="";
	}
	if(!namepattern.test(l_name)) {
		document.getElementById("error2").innerHTML="Invalid name";
		return false;
	}
		else {
		document.getElementById("error2").innerHTML="";
	}

	var email1=document.getElementById("email1").value;
	var email2=document.getElementById("email2").value;
	if(email1!=email2) {
		//window.alert("Email addresses doesn't match!!");
		document.getElementById("error6").innerHTML="Email addresses doesn't match!!";
	return false;	
	}
	else {
		document.getElementById("error6").innerHTML="";
	}

var mob=document.getElementById("mobile").value;
var mobilepattern=/^\d+$/;	
	if(!mobilepattern.test(mob)) {
		document.getElementById("error12").innerHTML="Invalid mobile number";
		return false;
	}
		else {
		document.getElementById("error12").innerHTML="";
	}

var useridstring=document.getElementById("uname").value;
var userpattern=/^[a-zA-Z0-9]{5,25}$/;
var result=userpattern.test(useridstring);
if(result==false) {
document.getElementById("error13").innerHTML="Invalid User name!!";
return false;
}
else {
document.getElementById("error13").innerHTML="";
}

var password=document.getElementById("pwd").value;
var passwordpattern=/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@$%^&#]+).{5,15}$/;
var result=passwordpattern.test(password);
if(result==false) {
document.getElementById("error14").innerHTML="Invalid password!!";
return false;
}
else {
document.getElementById("error14").innerHTML="";
}
	
return true;
}