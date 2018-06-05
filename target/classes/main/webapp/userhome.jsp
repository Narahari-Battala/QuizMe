<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file = "header_with_login_user.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.flex-container {
  display: flex;
  background-color: white;
    padding: 80px; 

}
input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 120px 120px;
    margin: 8px 0;
    border: none;
    border-radius: 2px;
    cursor: pointer;
}
.flex-container > div {
  background-color: #f1f1f1;
  margin: px;
  padding: 80px;
  font-size: 30px;
}
</style>
<body>


<div class="flex-container">

 <div><form action= "Practice" method="post">
<input type="submit" value ="Practise Questions !">
</form> 
</div>
 <div><form action= "ExamServlet" method="get"">
  
<input type="submit" value =" View Upcoming Exams!">
</form> </div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>