<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList" %>
 <%@page import="com.telusko.Bean.QuestionBean" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header_with_login_admin.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Questions</title>
</head>
<style>
.smart-green {
    margin-left:auto;
    margin-right:auto;

    max-width: 500px;
    background: #F8F8F8;
    padding: 30px 30px 20px 30px;
    font: 12px Arial, Helvetica, sans-serif;
    color: #666;
    border-radius: 5px;
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
}
.smart-green h1 {
    font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
    padding: 20px 0px 20px 40px;
    display: block;
    margin: -30px -30px 10px -30px;
    color: #FFF;
    background: #9DC45F;
    text-shadow: 1px 1px 1px #949494;
    border-radius: 5px 5px 0px 0px;
    -webkit-border-radius: 5px 5px 0px 0px;
    -moz-border-radius: 5px 5px 0px 0px;
    border-bottom:1px solid #89AF4C;

}
.smart-green h1>span {
    display: block;
    font-size: 11px;
    color: #FFF;
}

.smart-green label {
    display: block;
    margin: 0px 0px 5px;
}
.smart-green label>span {
    float: left;
    margin-top: 10px;
    color: #5E5E5E;
}
.smart-green input[type="text"], .smart-green input[type="email"], .smart-green textarea, .smart-green select {
    color: #555;
    height: 30px;
    line-height:15px;
    width: 100%;
    padding: 0px 0px 0px 10px;
    margin-top: 2px;
    border: 1px solid #E5E5E5;
    background: #FBFBFB;
    outline: 0;
    -webkit-box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
    box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
    font: normal 14px/14px Arial, Helvetica, sans-serif;
}
.smart-green textarea{
    height:100px;
    padding-top: 10px;
}
.smart-green select {
    background: url('down-arrow.png') no-repeat right, -moz-linear-gradient(top, #FBFBFB 0%, #E9E9E9 100%);
    background: url('down-arrow.png') no-repeat right, -webkit-gradient(linear, left top, left bottom, color-stop(0%,#FBFBFB), color-stop(100%,#E9E9E9));
   appearance:none;
    -webkit-appearance:none; 
   -moz-appearance: none;
    text-indent: 0.01px;
    text-overflow: '';
    width:100%;
    height:30px;
}
.smart-green input[type="submit"]{
    background-color: #9DC45F;
    border-radius: 5px;
    -webkit-border-radius: 5px;
    -moz-border-border-radius: 5px;
    border: none;
    padding: 10px 25px 10px 25px;
    color: #FFF;
    text-shadow: 1px 1px 1px #949494;
}
.smart-green .button:hover {
    background-color:#80A24A;
}
</style>
<body>
<form action ="adminhome" class="smart-green" method="post">
<c:set var="count" value="0" scope="page" />
<c:forEach var="table" items='${requestScope.qlist}'>
	<c:set var="count" value="${count + 1}" scope="page"/>
	  <c:out value="${count}"></c:out>
	  <c:out value="."/><nbsp>
	  <c:out value="${table.getQuestion()}"></c:out><br>
	  <c:out value="Sub Topic: "></c:out><c:out value="${table.getSubtopic()}"></c:out><br>
	  <c:out value="Level: "></c:out><c:out value="${table.getQ_level()}"></c:out><br>
<br>	  
</c:forEach>
<input type="submit" value="Go Back">
</form>
<%@include file="footer.jsp" %>
</body>
</html>