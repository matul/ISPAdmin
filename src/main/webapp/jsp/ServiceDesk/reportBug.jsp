<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
<h2>Nový tiket</h2>
<%@ include file="submenu.jsp" %>
<form:form method="POST" action="${action}" commandName="incident">
    <label>Předmět problému:</label>
    <form:input path="subject"></form:input>
    <form:errors path="subject" class="error"></form:errors>

    <label>Popis:</label>
    <form:textarea path="message"></form:textarea>
    <form:errors path="message" class="error"></form:errors>

    <input type="submit" name="submit" value="Odeslat" class="submit left" />
    <a href="../ispadmin/serviceDesk/list" class="submit left">Zrušit</a>
</form:form>
<%@ include file="../footer.jsp" %>
