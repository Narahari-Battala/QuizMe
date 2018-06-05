<!DOCTYPE html>
<html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header_without_login.jsp" %>
<head>
<style>
form { 
margin: 0 auto; 
width:500px;
left-margin: 50px;
right-margin: 4px;
padding:0px
width: 80px;
}

 div {
    background-color: #F2F2F2;
    width: 830px;
    border: 100px green;
    padding: 252px;
    left-margin: 30px;
    right-margin: 200px;
} 

input[type=text,password], select {
    width: 100%;
    padding: 12px 0px;
    margin: 8px 10;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 15%;
    background-color: #4CAF50;
    color: white;
    padding: 4px 55px;
    margin: 6px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

/* div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
} */
a:link {
    color: white;
    background-color: transparent;
    text-decoration: none;
}
</style>
</head>
<body>
<div>
 <fieldset>
<form class = "myform">
<br><marquee behavior="scroll" direction="right">** Please login here **</marquee><br><br><br>
</form>
<form class = "myform" action ="login" method="post">
  Username:
  <input type="text" name="username"><br><br>
  Password : 
  <input type="password" name="password"><br>
  <input type="submit" name="login" value="Login">
</form>
<form action="signup">			
	New User? <input type="submit" value="SignUp">
</form>
 </fieldset>
</div>
<%-- <%@include file="footer.jsp" %> --%>
</body>
</html>

