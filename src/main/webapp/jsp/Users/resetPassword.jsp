<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
<h2>Reset hesla</h2>
<%@ include file="submenu.jsp" %>
<form action="${action}" method="post" name="changePassword">
    <p>${errors.password}</p>
    <p>${errors.passwordVerification}</p>
    Nové heslo: <input type="text" name="password"/>
    Potvrzení hesla: <input type="text" name="passwordVerification"/>
    <input type="submit" value="odeslat" />
    
</form>
      
      
      
<%@ include file="../footer.jsp" %>
