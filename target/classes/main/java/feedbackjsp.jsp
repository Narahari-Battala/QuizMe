<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback</title>
</head>
<body>

<form action ="nextaction">
<h4>Your Score: <%= request.getSession().getAttribute("correct") %></h4>

<input type="radio" name="action" value="Recommendation" required> Recommendation <br>
<input type="radio" name="action" value="retake" required> Retake the Quiz on Same Topic<br>
<input type="radio" name="action" value="changetopic" required> Change topic of Quiz<br>
<input type="radio" name="action" value="quit" required> Quit <br><br>

<input type="submit" name ="submit" value="submit">

</form>
</body>
</html>