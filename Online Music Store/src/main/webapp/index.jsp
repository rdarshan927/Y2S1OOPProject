<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<% int id = 1; %>
<%
	//if(session.getAttribute("userid") == null){
		//response.sendRedirect("login.jsp");
	//}
//commented because login isn't my part

//index.jsp the home is also isn't my part this was made just for getting into my page
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//String userid = (String) session.getAttribute("userid");
	%>
	<a href="verify?id=<%= id %>"><button>Get Verified</button></a>
	


	
	
	
	
</body>
</html>
