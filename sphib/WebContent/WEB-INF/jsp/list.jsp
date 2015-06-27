<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function go(url)
{
	window.location = url;
}

function delete(url)
{
var isOk = confirm("are you sure?");

if(isOk){
	go(url);
}

	}
</script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<hr />
	<c:out value="${e}" />

	<c:forEach items="${contacts}" var="contact">

		<c:out value="${contact.fname}"></c:out>
		<c:out value="${contact.lname}"></c:out>
		<c:out value="${contact.gender}"></c:out>
		<c:out value="${contact.country}"></c:out>
		<a
			href="${pageContext.request.contextPath}/edita.htm?id=${contact.id}">edit</a>
		<a href="remov/${contact.id}.htm">delete</a>



		<hr />



	</c:forEach>



</body>
</html>