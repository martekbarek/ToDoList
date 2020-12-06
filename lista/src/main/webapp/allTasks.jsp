<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>


<ul>
	<c:forEach var="temp" items="${student.operSys}">
	<li> ${temp} </li>
	</c:forEach>
</ul>


<br> <br>
<a href="createTask.jsp">Create task to do</a>

</body>
</html>
