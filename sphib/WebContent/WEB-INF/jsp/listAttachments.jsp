<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<ul>
<c:forEach items="${accachments}" var="atc">

<li><c:out value="${atc.name}" /></li>
<li><a href="download/${atc.id}.htm">download
<img src="${pageContext.request.contextPath}/image/down.png" alt="download"/>

</a>

</li><li><a href="remova/${atc.id}.htm">delete</a></li>
<hr/>
</c:forEach>
</ul>
</body>
</html>