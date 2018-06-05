<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ include file = "header_with_login_admin.jsp" %>
<title>Admin Dashboard</title>
<head>
<style>
* {
    box-sizing: border-box;
}

.img-container {
    float: left;
    width: 33.33%;
    padding: 5px;
}

.clearfix::after {
    content: "";
    clear: both;
    display: table;
}

input[type=submit] {
    width: 100%;
    background-color: #4CAF50;
    color: white;
    padding: 40px 30px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

</style>
</head>
<body>

<h2>Admin Dashboard</h2>
<!-- <p>Hi Admin</p> -->

<div class="clearfix">
  <div class="img-container">
    <form action="createqusetion" method="post">
    <input type="submit" value="Add a Question">
</form>
  </div>
  <div class="img-container">
    <form action="showtopics" method="post">
    <input type="submit" name= "submit" value="Delete Questions">
</form>
  </div>
  <div class="img-container">
    <form action="showtopics" method="post">
    <input type="submit" name= "submit" value="View Questions">
</form>
  </div>
</div>


<div class="clearfix">
  <div class="img-container">
    <form action="viewsentiment" method="post">
    <input type="submit" value="View Sentiment Analysis">
</form>
  </div>
  <div class="img-container">
    <form action="viewleaderboard" method="post">
    <input type="submit"value="View Leaderboard">
</form>
  </div>
  <div class="img-container">
    <form action="addexampage" method="post">
    <input type="submit"value="Add Exams">
</form>
  </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>
