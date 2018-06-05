<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file = "header_without_login.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up</title>
</head>
<style>
input[type=text,password], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 35%;
    background-color: #4CAF50;
    color: white;
    padding: 4px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
<body>

    <div id="reg">
 <h2 class="centre" align="center">Registration Form</h2><br>
  <marquee behavior="scroll" direction="right">** All Fields are Mandatory **</marquee>
    <form action="userInfo" method="post"  onsubmit="return validateEntry();">
        <input type="hidden" name="action"  value="display" />
<table width="600px" align="center"  >
 
      <!-- table to display-->
 <tr>

<td width="400"><!-- <input type="radio" name="user" value="user" required> User
  <input type="radio" name="user" value="admin" required> Admin<br></td> -->
  <!--  <td><p id="emailError">${usertype}</p></td>-->
</tr>
<tr>
        <td  width="200">User Name</td>
        <td width="200">
          <input name="id" type="text" id="campusid"  size="30" maxlength="50" required/>
        </td>
</tr>

<tr>
        <td  width="200">First Name</td>
        <td width="200">
          <input name="firstname" type="text" id="fname"  size="30" required />
        </td>
</tr>

<tr>
        <td  width="200">Last Name</td>
        <td width="200">
          <input name="lastname" type="text" id="lname"  size="30" required/>
        </td>
</tr>

<tr>
        <td  width="200">Email Id</td>
        <td width="200">
          <input name="email" type="email" id="email" size="30" onblur="validateEmail();" required/>
        </td>
       
</tr>

    <tr>
        <td  width="200">Password</td>
        <td width="200">
          <input name="password" type="password" id="pwd" size="30" onblur="passwordValidate();" required/>
        </td>
        <td><p id="p"></p></td>
</tr>

 <tr>
        <td  width="200">Confirm Password</td>
        <td width="200">
          <input name="cpassword" type="password" id="cpwd" size="30" onblur="passwordCheck();" required/>
        </td>
        <td width="600"><p id="c"></p></td>
</tr>

 <tr>
        <td  width="200"></td>
        <td width="200">
       <input type="submit" name="submit" value="Register"  />
        </td>
        <td width="600"><p id="ud"></p></td>
</tr>

</table><br>

<div class="validate">
<!--	<c:if test="${not empty errormsg}">
    	${errormsg} <br> <br>
	</c:if> -->
	
	</div>
   



</form>
    <div class="centr" id="ud"> </div>
    </div>
<%@include file="footer.jsp" %>
</body>
</html>