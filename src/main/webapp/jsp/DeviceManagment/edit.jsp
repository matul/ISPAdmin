<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
<h2>Editace zařízení</h2>
<%@ include file="submenu.jsp" %>
<form:form method="POST" action="${action}" modelattribute="device" commandName="device">
  
  <form:input path="ipAdress"></form:input>
  <form:errors path="ipAdress" cssclass="error"></form:errors>

  <label>kde</label>
  <form:input path="localization"></form:input>
  <form:errors path="localization" cssclass="error"></form:errors>
    
  <label>kdo</label>
              <td>${i.getUser().getUsername()}</td>
              <td>${i.getUser().getFirstname()}</td>
              <td>${i.getUser().getSurname()}</td>

  <input type="submit" name="submit" value="Odeslat" />
</form:form>
<%@ include file="../footer.jsp" %>