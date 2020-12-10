<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New task</title>
</head>
<body>
<h1>New task</h1> 
<br> <hr>

	<form:form action="create" modelAttribute="task" method="post" >
	
		Content: <form:input path="content" />  <form:errors style="color:red" path="content"/>
		
		
		
		
		
		<input type="submit" value="Submit">
	
	</form:form>
<hr>

</body>
</html>