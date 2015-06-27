<%-- 
    Document   : attachment
    Created on : Mar 16, 2014, 9:35:28 PM
    Author     : americano
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attachment</title>
    </head>
    <body>
        <h1>Attachment</h1>
        
       
        <form:form action="upload.htm" method="post" modelAttribute="upfile" enctype="multipart/form-data">

<input type="file" name="mf" />
<form:errors path="mf" />
<input type="submit" value="submit" />

</form:form>
        
        
            
    </body>
</html>
