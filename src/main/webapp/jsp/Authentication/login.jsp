<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="layout/header.jsp" %>
<h2>Přihlášení</h2>
<c:if test="${not empty sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}">
  <div class="msg error">
    ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}                  
  </div>
  <div class="msg question">
    <a name="recovery" href="${sendForgottenPasswordLink}">Zapomněli jste heslo?</a>  
  </div>
</c:if>

<form name='f' action='${action}' method='POST' class="loginform">                    
  <label>Přihlašovací jméno:</label>  
  <input type='text' name='j_username' >

  <label>Heslo:</label>
  <input type='password' name='j_password' />  

  <input name="submit" type="submit" value="Přihlásit" class="submit" />  
</form> 
<%@ include file="layout/footer.jsp" %>