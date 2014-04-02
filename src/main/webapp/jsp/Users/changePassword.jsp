<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
<h2>Změna hesla</h2>
<%@ include file="submenu.jsp" %>
<form action="${action}" method="post" name="changePassword">
    <p>${errors.oldPassword}</p>
    <p>${errors.newPassword}</p>
    <p>${errors.passwordVerification}</p>
    <label>Zadejte staré heslo:</label> <input type="password" name="oldPassword"/>
    <label>Nové heslo:</label> <input type="password" name="newPassword"/>
    <label>Potvrzení hesla:</label> <input type="password" name="passwordVerification"/>
    <input type="submit" value="odeslat" /> 
    <p>${success}</p>
</form>

<%@ include file="../footer.jsp" %>
