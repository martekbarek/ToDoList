<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit task</title>
</head>
<body>
<h1>Edit task</h1> 
<br> <hr>

	<form:form method="post" action="edit" modelAttribute="task">
	
		<form:hidden path="id"/>
		Content:  <form:input path="content"/> <form:errors style="color:red" path="content" cssClass="error"/>
		
		
		
		<input type="submit" >
	
	</form:form>
<hr>

</body>
</html>