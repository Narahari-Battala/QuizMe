<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header_with_login_user.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback</title>
</head>
<style>
.white-pink {
    margin-left:auto;
    margin-right:auto;

    max-width: 500px;
    background: #FFF;
    padding: 30px 30px 20px 30px;
    box-shadow: rgba(187, 187, 187, 1) 0 0px 20px -1px;
    -webkit-box-shadow: rgba(187, 187, 187, 1) 0 0px 20px -1px;
    font: 12px Arial, Helvetica, sans-serif;
    color: #666;
    border-radius: 10px;
    -webkit-border-radius: 10px;
}
.white-pink h1 {
    font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
    padding: 0px 0px 10px 40px;
    display: block;
    border-bottom: 1px solid #F5F5F5;
    margin: -10px -30px 10px -30px;
    color: #969696;
}
.white-pink h1>span {
    display: block;
    font-size: 11px;
    color: #C4C2C2;
}
.white-pink label {
    display: block;
    margin: 0px 0px 5px;
}
.white-pink label>span {
    float: left;
    width: 20%;
    text-align: right;
    padding-right: 10px;
    margin-top: 10px;
    color: #969696;
}
.white-pink input[type="text"], .white-pink input[type="email"], .white-pink textarea,.white-pink select{
    color: #555;
    width: 70%;
    padding: 3px 0px 3px 5px;
    margin-top: 2px;
    margin-right: 6px;
    margin-bottom: 16px;
    border: 1px solid #e5e5e5;
    background: #fbfbfb;
    height: 25px;
    line-height:15px;
    outline: 0;
    -webkit-box-shadow: inset 1px 1px 2px rgba(200,200,200,0.2);
    box-shadow: inset 1px 1px 2px rgba(200,200,200,0.2);
}
.white-pink textarea{
    height:100px;
    padding: 5px 0px 0px 5px;
    width: 70%;
}
.white-pink .button {
    -moz-box-shadow:inset 0px 1px 0px 0px #fbafe3;
    -webkit-box-shadow:inset 0px 1px 0px 0px #fbafe3;
    box-shadow:inset 0px 1px 0px 0px #fbafe3;
    background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ff5bb0), color-stop(1, #ef027d) );
    background:-moz-linear-gradient( center top, #ff5bb0 5%, #ef027d 100% );
    filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ff5bb0', endColorstr='#ef027d');
    background-color:#ff5bb0;
    border-radius:9px;
    -webkit-border-radius:9px;
    -moz-border-border-radius:9px;
    border:1px solid #ee1eb5;
    display:inline-block;
    color:#ffffff;
    font-family:Arial;
    font-size:15px;
    font-weight:bold;
    font-style:normal;
    height: 40px;
    line-height: 30px;
    width:100px;
    text-decoration:none;
    text-align:center;
    text-shadow:1px 1px 0px #c70067;
}
.white-pink .button:hover {
    background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ef027d), color-stop(1, #ff5bb0) );
    background:-moz-linear-gradient( center top, #ef027d 5%, #ff5bb0 100% );
    filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ef027d', endColorstr='#ff5bb0');
    background-color:#ef027d;
}
.white-pink .button:active {
    position:relative;
    top:1px;
}
.white-pink select {
    background: url('down-arrow.png') no-repeat right, -moz-linear-gradient(top, #FBFBFB 0%, #E9E9E9 100%);
    background: url('down-arrow.png') no-repeat right, -webkit-gradient(linear, left top, left bottom, color-stop(0%,#FBFBFB), color-stop(100%,#E9E9E9));
   appearance:none;
    -webkit-appearance:none; 
   -moz-appearance: none;
    text-indent: 0.01px;
    text-overflow: '';
    width: 70%;
    line-height: 15px;
    height: 30px;
}
</style>
<body>

<form action ="savenotebook" class="white-pink" method="post">
<h4>Notebook Name: <%= request.getAttribute("nbname") %><br></h4>
Notebook content:<br><br>
<textarea name="content" rows="10" cols="70"><%= request.getAttribute("content") %></textarea><br><br>
<input type="submit" value="Save Notebook">
</form>
<%@include file="footer.jsp" %>
</body>
</html>