<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
<h2>Reset hesla</h2>
<%@ include file="submenu.jsp" %>
<c:if test="${not empty success.reset}">
    <div class="msg ok">
        <p>${success.reset}</p>
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
    <label>Nové heslo:</label> 
    <input type="password" name="password"/>
    
    <label>Potvrzení hesla:</label> 
    <input type="password" name="passwordVerification"/>
    
    <input type="submit" value="Odeslat" class="submit left" />
    <a href="${leaveLink}" class="submit left">Zrušit</a>    
</form>   
      
<%@ include file="../footer.jsp" %>
