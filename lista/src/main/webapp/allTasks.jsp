<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<body>


<form:form action="deleteTask" modelAttribute="deleteTasks">
	<c:forEach var="task" items="${tasks}">
	<tr>
	<td><form:checkbox path="todel" value="${task.id}" />  ${task.content} | ${task.data} <br></td>
	</tr>
	</c:forEach>
	<input type="submit" value="WYKONANE">
</form:form>

<a href="createTask.jsp">Create task to do</a>

</body>
</html>
