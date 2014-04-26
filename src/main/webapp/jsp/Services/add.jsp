<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
    <h2>Přidání/úprava služby</h2>
    <%@ include file="submenu.jsp" %>
    <form:form method="POST" action="${action}" modelattribute="service" commandName="service">
      <label>Název služby:</label>
      <form:input path="name"></form:input>
      <form:errors path="name" class="error"></form:errors>

      <label>Popis:</label>
      <form:textarea path="description"></form:textarea>
      <form:errors path="description" class="error"></form:errors>

      <label>Cena:</label>
      <form:input path="price"></form:input>
      <form:errors path="price" class="error"></form:errors>   

      <input type="submit" name="submit" value="Uložit změny" class="submit left" />
      <a href="${leaveLink}" class="submit left">Zrušit</a>
    </form:form>
<%@ include file="../footer.jsp" %>
