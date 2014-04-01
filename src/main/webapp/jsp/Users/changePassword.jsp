<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
<h2>Změna hesla</h2>
<%@ include file="submenu.jsp" %>
<form action="${action}" method="post" name="changePassword">
    <p>${errors.password}</p>
    <p>${errors.passwordVerification}</p>

    Zadejte staré heslo: <input type="password" name="oldPassword"/>
    Nové heslo: <input type="password" name="newPassword"/>
    Potvrzení hesla: <input type="password" name="passwordVerification"/>
    <input type="submit" value="odeslat" /> 
</form>

<%@ include file="../footer.jsp" %>