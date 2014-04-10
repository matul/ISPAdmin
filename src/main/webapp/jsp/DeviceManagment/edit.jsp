<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
<h2>Editace zařízení</h2>
<%@ include file="submenu.jsp" %>
<form:form method="POST" action="${action}" modelattribute="device" commandName="device">
    <label>IP adresa:</label>
    <form:input path="ipAdress"></form:input>
    <form:errors path="ipAdress" class="error"></form:errors>

    <label>Lokalizace:</label>
    <form:input path="localization"></form:input>
    <form:errors path="localization" class="error"></form:errors>

    <label>Uživatel:</label>
    <label>${i.getUser().getUsername()}</label>
    <label>${i.getUser().getFirstname()}</label>
    <label>${i.getUser().getSurname()}</label>

    <input type="submit" name="submit" value="Odeslat" class="submit left" />
    <a href="../ispadmin/DeviceManagment/list" class="submit left">Zrušit</a>
</form:form>
<%@ include file="../footer.jsp" %>