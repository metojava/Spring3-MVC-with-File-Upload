<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="not empty ${contact}">

<table>
<tr><th colspan="2">contact</th></tr>
<tr><td>First Name :</td><td>${contact.fname}</td></tr>
<tr><td>Last Name :</td><td>${contact.lname}</td></tr>
<tr><td>Salary :</td><td>${contact.salary}</td></tr>

</table>

</c:if>
<a href="contactForm">add new contact</a>

</body>
</html>