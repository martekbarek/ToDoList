<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>


<!DOCTYPE html>
<html>
<head>
	    <link href="<c:url value="/resources/style.css" />" rel="stylesheet">
</head>
<body>
<h1>Your tasks</h1>

<form id="editTask"  method="post" action="editTask"></form>
<form id="deleteTask" method="post" action="deleteTask" >
	<c:forEach var="task" items="${tasks}">
	<tr>
	<td><input form="deleteTask" type="checkbox" value="${task.id}" name="id" onclick="this.form.submit();">  ${task.content} <button form="editTask" type="submit" value="${task.id}" name="id" >Edit</button>   <br></td>
	</tr>
	</c:forEach>
</form>

<a href="createTask">New task</a>

</body>
</html>
