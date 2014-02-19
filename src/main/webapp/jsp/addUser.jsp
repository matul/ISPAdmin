<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <base href="http://localhost:8080/ispadmin/" />
        <title>ISP Admin - Seznam klientů</title>

        
        <link href="resources/media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="resources/media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="resources/media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="resources/media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />
        <link href="resources/media/datedit.css" rel="stylesheet" type="text/css" />
        <link href="resources/media/site.css" rel="stylesheet" type="text/css" />
        <link href="resources/media/images.css" rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ISP Admin - Přidání klienta</title>
    </head>
    <body>
        <h1>Přidání klienta</h1>
        <form:form method="POST" action="/ispadmin/user/add" modelattribute="user" commandName="user">
            <label for="username">Username: </label>
            <form:input path="username" id="username"></form:input>
            <form:errors path="username" cssclass="error"></form:errors>
            <br />
            
            <label for="firstname">Firstname: </label>
            <form:input path="firstname" id="firstname"></form:input>
            <form:errors path="firstname" cssclass="error"></form:errors>
            <br />
            
            <label for="surname">Surname: </label>
            <form:input path="surname" id="surname"></form:input>
            <form:errors path="surname" cssclass="error"></form:errors>
            <br />
            
            <label for="description">Description: </label>
            <form:textarea path="description" id="description"></form:textarea>
            <form:errors path="description" cssclass="error"></form:errors>
            <br />
            
            <input type="submit" name="submit" />
        </form:form>        
        
    </body>
</html>
