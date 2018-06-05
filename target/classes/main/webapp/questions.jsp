<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.*"%>
<%
	//String id = request.getParameter("userId");
	String driverName = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/playdb";
	//String dbName = "jsptutorials";
	String userId = "root";
	String password = "password";  
    ArrayList<String> q_list = new ArrayList<String>(); 
	try {
		Class.forName(driverName);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
%>

<!-- <form action = "feedback">
  <form></form> -->
<h2 align="center">
	<font><strong>Retrieve data from database in jsp</strong></font>
</h2>
 <form action = "feedback">
<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>

	</tr>
<!-- 	<tr bgcolor="#A52A2A">
		<td><b>id</b></td>
		<td><b>user_id</b></td>
		<td><b>Password</b></td>
		<td><b>Name</b></td>
		<td><b>Email</b></td>
	</tr> -->
	<%
		try {
			connection = DriverManager.getConnection(connectionUrl, userId, password);
			statement = connection.createStatement();
			String q_exam = "select * from questionbank where q_id in ('200','201');";
			resultSet = statement.executeQuery(q_exam);
			while (resultSet.next()) {
			q_list.add(resultSet.getString("q_id"));
	%>
	<tr bgcolor="#DEB887">

		<td><%=resultSet.getString("q_details")%></td>
		<%-- <td><%=resultSet.getString("user_id")%></td>
		<td><%=resultSet.getString("password")%></td>
		<td><%=resultSet.getString("name")%></td>
		<td><%=resultSet.getString("email")%></td> --%>

	</tr>

	<%
		}
	 %>
		  <input type="submit" name="submit">
          </form>
	<% 		

		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
</table>