<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="layout/header.jsp" %>

<h2>Zaslání odkazu pro obnovu hesla</h2>
<c:if test="${not empty errors.userNotFound}">
    <div class="msg error">
        <p>${errors.userNotFound}</p>                 
    </div>
</c:if>
<c:if test="${not empty errors.emailVerification}">
    <div class="msg error">
        <p>${errors.emailVerification}</p>
    </div>
</c:if>

<c:if test="${not empty success.sendPassword}">
    <div class="msg ok">
        <p>${success.sendPassword}</p>
    </div>
</c:if>

<form action="${action}" method="post" property="userame" name="sendPassword">

    <label>Uživatelské jméno</label>
    <input type="text" name="username"/>

    <label>Email</label>
    <input type="text" name="email"/>

    <input name="submit" type="submit" value="Odeslat" class="submit" />   
</form> 

<%@ include file="layout/footer.jsp" %>