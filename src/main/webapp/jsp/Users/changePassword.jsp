<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
<h2>Změna hesla</h2>
<%@ include file="submenu.jsp" %>
<c:if test="${not empty success.change}">
    <div class="msg ok">
        <p>${success.change}</p>
    </div>
</c:if>
<c:if test="${not empty errors.oldPassword}">
    <div class="msg error">
        <p>${errors.oldPassword}</p>
    </div>
</c:if>
<c:if test="${not empty errors.newPassword}">
    <div class="msg error">
        <p>${errors.newPassword}</p>
    </div>
</c:if>
<c:if test="${not empty errors.passwordVerification}">
    <div class="msg error">
        <p>${errors.passwordVerification}</p>
    </div>
</c:if>
<form action="${action}" method="post" name="changePassword">    
    <label>Zadejte staré heslo:</label> 
    <input type="password" name="oldPassword"/>
    
    <label>Nové heslo:</label> 
    <input type="password" name="newPassword"/>
    
    <label>Potvrzení hesla:</label> 
    <input type="password" name="passwordVerification"/>
    
    <input type="submit" value="Odeslat" class="submit left" /> 
    <a href="${leaveLink}" class="submit left">Zrušit</a>
</form>

<%@ include file="../footer.jsp" %>
