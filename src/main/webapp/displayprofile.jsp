<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.telusko.Bean.ProfileBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<%@ include file = "header_with_login_user.jsp" %>
<head>

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
<%ProfileBean pb = (ProfileBean) request.getAttribute("profile");
%>

<h2>My Profile Info</h2>
<div class="container">
      <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title"><%=pb.getUsername() %></h3>
            </div>
            <div class="panel-body">
              <div class="row">
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information" id="customers">
                    <tbody>
                      <tr>
                        <td>First Name:</td>
                        <td><%=pb.getFirstname() %></td>
                      </tr>
                      <tr>
                        <td>Last Name:</td>
                        <td><%=pb.getLastname() %></td>
                      </tr>
                       <tr>
                        <td>User Name:</td>
                        <td><%=pb.getUsername() %></td>
                      </tr>
                      <tr>
                        <td>Email</td>
                        <td><%=pb.getEmail() %></td>
                      </tr>            
                             <%-- <tr>
                        <td>Current Overall Score
                        </td>
                        <td><%=pb.getAvgscore() %></td>
                      </tr> --%>
                        <tr>
                        <td>Upcoming Exam</td>
                        <td>05-02-2018</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>    
          </div>
        </div>
      </div>
    </div>
<%@include file="footer.jsp" %>
</body>
</html>