<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
    <h2>Přidání/úprava faktury</h2>
    <%@ include file="submenu.jsp" %>
    <form:form method="POST" action="${action}" modelattribute="invoice" commandName="invoice">
        
        <label>Datum vystavení:</label>
        <form:input path="issueDate"></form:input>
        <form:errors path="issueDate" class="error"></form:errors>

        <label>Datum splatnosti:</label>
        <form:input path="dueDate"></form:input>
        <form:errors path="dueDate" class="error"></form:errors>

        <label>Cena:</label>
        <form:input path="price"></form:input>
        <form:errors path="price" class="error"></form:errors>

        <input type="submit" name="submit" value="Uložit změny" class="submit left" />
        <a href="${leaveLink}" class="submit left">Zrušit</a>
       
    </form:form>
<%@ include file="../footer.jsp" %>
