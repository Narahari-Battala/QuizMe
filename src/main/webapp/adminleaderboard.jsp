<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.ArrayList" %>
 <%@page import="com.telusko.Bean.QuestionBean" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Current Leaderboard:</title>
<%@ include file = "header_with_login_admin.jsp" %>
</head>
<style>
table {  
    color: #333;
    font-family: Helvetica, Arial, sans-serif;
    width: 640px; 
    border-collapse: 
    collapse; border-spacing: 0; 
}

td, th {  
    border: 1px solid transparent; /* No more visible border */
    height: 30px; 
    transition: all 0.3s;  /* Simple transition for hover effect */
}

th {  
    background: #DFDFDF;  /* Darken header a bit */
    font-weight: bold;
}

td {  
    background: #FAFAFA;
    text-align: center;
}

/* Cells in even rows (2,4,6...) are one color */        
tr:nth-child(even) td { background: #F1F1F1; }   

/* Cells in odd rows (1,3,5...) are another (excludes header cells)  */        
tr:nth-child(odd) td { background: #FEFEFE; }  

tr td:hover { background: #666; color: #FFF; }  
/* Hover cell effect! */
</style>
<body>
<form action ="GoHome" method="post">
<h3>Current Leaderboard:</h3>
<table>
  <tr>
    <th>User Name</th>
    <th>Score</th> 
  </tr>
	<c:forEach var="table" items='${requestScope.lblist}'>
	<tr>
	<td><c:out value="${table.getUsername()}"></c:out><br></td>
	<td><c:out value="${table.getScore()}"></c:out><br></td>
	</tr>
	</c:forEach>
</table>
</form>
<%@include file="footer.jsp" %>
</body>
</html>
