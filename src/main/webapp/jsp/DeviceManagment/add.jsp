<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
    <h2>Přidání/úprava zařízení</h2>
    <%@ include file="submenu.jsp" %>
    <form:form method="POST" action="${action}" modelattribute="device" commandName="device">
      <label>IP adresa</label>
      <form:input path="ipAdress"></form:input>
      <form:errors path="ipAdress" cssclass="error"></form:errors>

      <label>Lokace</label>
      <form:input path="localization"></form:input>
      <form:errors path="localization" cssclass="error"></form:errors>

      <label>MAC adresa</label>
      <form:input path="macAdress"></form:input>
      <form:errors path="macAdress" cssclass="error"></form:errors>

      <label>Výrobce</label>
      <form:input path="manufacturer"></form:input>
      <form:errors path="manufacturer" cssclass="error"></form:errors>
      
      <label>Typ</label>
      <form:input path="model"></form:input>
      <form:errors path="model" cssclass="error"></form:errors>

      <label>Název</label>
      <form:input path="name"></form:input>
      <form:errors path="name" cssclass="error"></form:errors>
      
      <input type="submit" name="submit" value="Uložit změny" />
       
    </form:form>
<%@ include file="../footer.jsp" %>
