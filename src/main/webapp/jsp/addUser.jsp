<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <base href="http://localhost:8080/ispadmin/" />
        <link href="resources/media/site.css" rel="stylesheet" type="text/css" />
        <link href="resources/media/images.css" rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ISP Admin - Přidání klienta</title>
    </head>
    <body>
        <h1>Přidání klienta</h1>
        <form:form method="POST" action="/ispadmin/user/add" modelattribute="user" commandName="user">
            <label for="usernameId">Username: </label>
            <form:input path="username" id="usernameId"></form:input>
            <form:errors path="username" cssclass="error"></form:errors>
            <br />
            
            <label for="firstnameId">Firstname: </label>
            <form:input path="firstname" id="firstnameId"></form:input>
            <form:errors path="firstname" cssclass="error"></form:errors>
            <br />
            
            <label for="surnameId">Surname: </label>
            <form:input path="surname" id="surnameId"></form:input>
            <form:errors path="surname" cssclass="error"></form:errors>
            <br />
            
            <label for="descriptionId">Description: </label>
            <form:textarea path="description" id="descriptionId"></form:textarea>
            <form:errors path="description" cssclass="error"></form:errors>
            <br />
            
            <input type="submit" name="submit" />
        </form:form>        
        
    </body>
</html>
