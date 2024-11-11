<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.sql.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment 2 Question 10</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th,td{
	padding:1rem;
}
th{
	background-color: skyblue;
}
</style>
</head>
<body>
<%
	String regNum=request.getParameter("regNum");
	String DBUrl = "jdbc:oracle:thin:@localhost:1521:xe"; 
	String DBUser = "ROOT";
	String DBPassword = "1234";

	Connection conn = null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(DBUrl, DBUser, DBPassword);
		PreparedStatement pstmt=conn.prepareStatement("SELECT regno, name, subject, marks FROM student WHERE regno = ?");
	    pstmt.setString(1,regNum);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
            out.println("<table>");
            out.println("<tr><th>Reg No</th><th>Name</th><th>Subject</th><th>Marks</th></tr>");
            do {
                out.println("<tr>");
                out.println("<td>" + rs.getString("regno") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("subject") + "</td>");
                out.println("<td>" + rs.getInt("marks") + "</td>");
                out.println("</tr>");
            } while (rs.next());
            out.println("</table>");
        } else {
            out.println("<p>No records found for Register Number: " + regNum + "</p>");
        }
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		conn.close();
	}
%>
</body>
</html>