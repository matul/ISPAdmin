<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="layout/header.jsp" %>
<h2>Přihlášení</h2>
<c:if test="${not empty sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}">
    <div class="msg error">
        ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}                  
    </div>
</c:if>

<div class="msg question">
    <a name="recovery" href="/ispadmin/authentication/sendForgottenPasswordLink">Zapomněli jste heslo?</a>  
</div>
<form name='f' action='/ispadmin/j_spring_security_check' method='POST' class="loginform">                    
    <label>Přihlašovací jméno:</label>  
    <input type='text' name='j_username' >

    <label>Heslo:</label>
    <input type='password' name='j_password' />  

    <input name="submit" type="submit" value="Přihlásit" class="submit" />  
</form> 
<%@ include file="layout/footer.jsp" %>