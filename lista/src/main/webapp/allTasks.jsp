<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<body>
<h1>Your tasks</h1>

<form action="deleteTask" >
	<c:forEach var="task" items="${tasks}">
	<tr>
	<td><input type="checkbox" value="${task.id}" name="id" onclick="this.form.submit();">  ${task.content} | ${task.data} <br></td>
	</tr>
	</c:forEach>
</form>

<a href="createTask.jsp">New task</a>

</body>
</html>
