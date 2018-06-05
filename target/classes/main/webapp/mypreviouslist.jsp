<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList" %>
 <%@page import="com.telusko.Bean.QuestionBean" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "header_with_login_user.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Previous Notes</title>
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
<form action ="notesaction" method="post">
<h3>Your Previous Notebooks:</h3>
<table id="customers">
  <tr>
   <th></th>
    <th>Notebook Name</th>
    <th>Last Updated</th>
  </tr>
	<c:forEach var="table" items='${requestScope.noteslist}'>
	<tr>
	 <td><input type="radio" name="id" value="${table.getId()}"><nbsp></nbsp></td>
	<td><c:out value="${table.getNotebook_name()}"></c:out><br></td>
	<td><c:out value="${table.getLastupdated()}"></c:out><br></td>
	</tr>
	</c:forEach>
</table>
<input type="submit" name="notes" value="View Content">
<input type="submit" name="notes" value="Add New Notebook">
</form>
<%@include file="footer.jsp" %>
</body>
</html>
