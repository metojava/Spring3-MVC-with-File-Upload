<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
function doit()
{
alert("hello");

	}
</script>

<style>
#main
{
margin:0 auto;
width:980px; 
}

#header
{
height:120px;
width:inherit; 
margin:0 auto;
text-align:center;
}
#regs
{
width:600px;
border: 1px solid #eee; 
list-style:none;
margin:0 auto;
}
#regs li
{
border-bottom: 1px solid light-blue;
margin-top:5px;
text-align:center;
clear:left;
display:block;
}

#regs span
{
clear:left;
width:40%;
margin-left:100px;
border:2px solid #aabbcc;
margin-right:10px;
}
#regs #subm
{
align:center; 
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="main">

<div id="header">
Your Logo Goes Here
</div>

<c:out value="${id}"/>
<ul id="regs">
<c:url value="save.htm" var="reg" />
<form:form method="post" commandName="contact" action="${reg}">
<li><span>First Name : </span><form:input path="fname" /></li>
<li><span>Last Name : </span><form:input path="lname" /></li>

<li><span>Gender : </span><form:radiobuttons path="gender" items="${gen}" /></li>

<li><span>Country : </span><form:select path="country"  items="${country}" />

</li>


<input type="submit" value="add" id="subm" onclick="doit()"/>
</form:form>
</ul>

</div>
</body>
</html>