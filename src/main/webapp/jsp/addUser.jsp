<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
    <h1>Přidání/úprava klienta</h1>
    <form:form method="POST" action="${action}" modelattribute="user" commandName="user">
      <label>Uživatelské jméno</label>
      <form:input path="username"></form:input>
      <form:errors path="username" cssclass="error"></form:errors>

      <label>Jméno</label>
      <form:input path="firstname"></form:input>
      <form:errors path="firstname" cssclass="error"></form:errors>

      <label>Příjmení</label>
      <form:input path="surname"></form:input>
      <form:errors path="surname" cssclass="error"></form:errors>

      <label>Město</label>
      <form:input path="city"></form:input>
      <form:errors path="city" cssclass="error"></form:errors>
      
      <label>Ulice</label>
      <form:input path="street"></form:input>
      <form:errors path="street" cssclass="error"></form:errors>

      <label>Číslo popisné</label>
      <form:input path="post_code"></form:input>
      <form:errors path="post_code" cssclass="error"></form:errors>
      
      <label>Datum narození</label>
      <form:input path="birthDate" placeholder="formát d.m.rrrr např. 1.2.1990"></form:input>
      <form:errors path="birthDate" cssclass="error"></form:errors>
      
      <label>Email</label>
      <form:input path="email"></form:input>
      <form:errors path="email" cssclass="error"></form:errors>
      
      <label>Telefon</label>
      <form:input path="phone_number" placeholder="číslo musí začínat +420 nebo +421"></form:input>
      <form:errors path="phone_number" cssclass="error"></form:errors>
      
      <label>Popis</label>
      <form:textarea path="description"></form:textarea>
      <form:errors path="description" cssclass="error"></form:errors>
      
      <input type="submit" name="submit" value="Uložit změny" />
    </form:form>
<%@ include file="foot.jsp" %>
