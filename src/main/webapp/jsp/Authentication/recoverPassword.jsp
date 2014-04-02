<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="layout/header.jsp" %>
<h2>Zadání nového hesla</h2>
<c:if test="${not empty success.recover}">
    <div class="msg ok">
        <p>${success.recover}</p>
    </div>
    <div class="msg none">
        <a href="/authentication/login">Přejít na login</a>
    </div>
</c:if>
<c:if test="${not empty errors.password}">
    <div class="msg error">
        <p>${errors.password}</p>
    </div>
</c:if>
<c:if test="${not empty errors.passwordVerification}">
    <div class="msg error">
        <p>${errors.passwordVerification}</p>
    </div>
</c:if>
<form action="${action}" method="post" name="resetPassword">
    <c:if test="${not empty errors.invalidLink}">
      <div class="msg error">
          <p>${errors.invalidLink}</p>
      </div>
    </c:if>
    
    <label>Nové heslo:</label> 
    <input type="text" name="password"/>
    
    <label>Potvrzení hesla:</label> 
    <input type="text" name="passwordVerification"/>
    
    <input type="submit" value="odeslat" class="submit"/>
</form>
<%@ include file="layout/footer.jsp" %>