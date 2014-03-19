<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
    <form:form method="POST" action="${action}" modelattribute="incident" commandName="incident">
      <label>Předmět problému</label>
      <form:input path="subject"></form:input>
      <form:errors path="subject" cssclass="error"></form:errors>

      <label>Popis</label>
      <form:input path="message"></form:input>
      <form:errors path="message" cssclass="error"></form:errors>
      
      <input type="submit" name="submit" value="Odeslat" />
    </form:form>
<%@ include file="footer.jsp" %>
