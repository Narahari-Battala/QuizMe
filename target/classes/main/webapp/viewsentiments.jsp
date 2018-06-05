<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList" %>
 <%@page import="com.telusko.Bean.QuestionBean" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header_with_login_admin.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Sentiment Analysis</title>
</head>
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}
#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}
#customers tr:nth-child(even){background-color: #f2f2f2;}
#customers tr:hover {background-color: #ddd;}
#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
input[type=submit] {
background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}
</style>
<body>
<br><br><br>
<form action ="getreportoptions" method="post">
<table id="customers">
  <tr>
   <th>Topic</th>
    <th>Predicted Labels</th>
    <th>Count</th> 
  </tr>
	<c:forEach var="table" items='${requestScope.ablist}'>
	<tr>
	<td><c:out value="${table.getTopic()}"></c:out><br></td>
	<td><c:out value="${table.getPredicted_label()}"></c:out><br></td>
	<td><c:out value="${table.getCount()}"></c:out><br></td>
	</tr>
	</c:forEach>
</table>
<input type="submit" value="Get Detailed Report">
</form>
<%@include file="footer.jsp" %>
</body>
</html>
