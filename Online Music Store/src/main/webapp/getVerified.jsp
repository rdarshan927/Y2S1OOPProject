<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	//if(session.getAttribute("userid") == null){
		//response.sendRedirect("login.jsp");
	//}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Verified</title>
<link rel="stylesheet" href="css/verification.css">
<script src="verified.js"></script>
</head>
<body>
	<%
		String userid = (String) session.getAttribute("userid");
	%>

	<div class="content">
		<div class="box-form">
		<c:forEach items="${verificationApplications}" var="application">
			<c:if test="${application.id == 0}">
            	<h1 class="register">Get Verified!</h1>
            </c:if>
            <c:if test="${application.id != 0}">
            	<h1 class="register">Edit Submitted Application</h1>
            </c:if>
			
			<form action="<c:choose><c:when test='${application.id != 0}'>edit</c:when><c:otherwise>post</c:otherwise></c:choose>" method="post">
				
				<label for="full-name">Applicant Full Name</label><br>
				<input  type="text" id="full-name" value="${application.fullname}" placeholder="Enter your full name" name = "full-name" class="font" maxlength="30" pattern="[A-Za-z\s]+" title="Full name should not contain numbers" required/><br><br>
	            
				<label for="nic">NIC</label><br>
				<input type="text" id="nic" value="${application.nic}" placeholder="Enter your NIC" name="nic"class="font" maxlength="12" pattern="[0-9]{12}" title="NIC should be exactly 10 numbers" required/><br><br>        
	            
	            <label for="mobile">Current Mobile Number</label><br>
	            <input type="text" id="mobile" value="${application.mobile}" placeholder="Enter the current working mobile number" name="mobile"class="font" maxlength="10" pattern="[0-9]{10}" title="Phone number should be exactly 10 numbers" required/><br><br>                
	                
	            <label for="email">Email ID</label><br>
	            <input type="email" id="email" value="${application.email}" placeholder="Enter the email address"name="email" class="font"maxlength="30" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" title="Please enter a valid email address" required/><br><br>            
	            
	            <label for="address">Current Address</label><br>
	            <input type="text" id="address" value="${application.address}" placeholder="Enter the current address"name="address" class="font"  required/><br><br>                        
	            	            	                
	            <c:if test="${application.id == 0}">
            		<input type="checkbox" id="terms" value="accepted"required>
	            	<span>Accept terms and conditions</span><br><br>
            	</c:if>
	    	    <input type="hidden" name="userid" id="userid" value="${application.userID}">                             
	            <div class="button">
	            	<a href="index.jsp" class = "account">Go Back to Profile</a>
	                <!-- <a href="userServlet?id=<%= userid %>" class = "account">Go Back to Profile</a>-->
		            <button class="submit-button" name="submit">
		            	<c:if test="${application.id == 0}">Submit</c:if>
		            	<c:if test="${application.id != 0}">Re-submit</c:if>
		            </button>
		            <br>
		            <c:if test="${application.id != 0}">
		            	<a href="delete?id=<c:out value='${application.id}' />">Delete Apllication</a>
		            </c:if>
	            </div>
	            
			</form>
			</c:forEach>
			
		</div>
	</div>
	<c:if test="${not empty errorMessage}">
	<script>
		document.addEventListener("DOMContentLoaded", function() {
		  var confirmation = confirm("NIC or Email ID already exists!");
		
		  if (confirmation) {
		    // Proceed with accessing the page
		  } else {
		    window.history.back(); // Go back to the previous page
		  }
		});
		
		
	</script>
	</c:if>

</body>
</html>