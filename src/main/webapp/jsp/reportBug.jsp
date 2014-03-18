<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="http://localhost:8080/ispadmin/" />
    <link href="resources/media/site.css" rel="stylesheet" type="text/css" />
    <link href="resources/media/images.css" rel="stylesheet" type="text/css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Nahlášení chyby</title>
  </head>
  <body>
    <h1>Nahlášení chyby</h1>
    <form:form method="POST" action="${action}" modelattribute="incident" commandName="incident">
      <label>Předmět problému</label>
      <form:input path="subject"></form:input>
      <form:errors path="subject" cssclass="error"></form:errors>

      <label>Popis</label>
      <form:input path="dmessage"></form:input>
      <form:errors path="message" cssclass="error"></form:errors>
      
      <input type="submit" name="submit" value="Odeslat" />
    </form:form>
  </body>
</html>
