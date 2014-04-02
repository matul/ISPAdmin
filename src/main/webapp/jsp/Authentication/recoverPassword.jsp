<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="layout/header.jsp" %>
<h2>Zadání nového hesla</h2>
<c:if test="${not empty success}">
    <div class="msg ok">
        <p>${success}</p>
    </div>
</c:if>

<form action="${action}" method="post" name="resetPassword">
    <c:if test="${not empty errors.invalidLink}">
      <div class="msg error">
          <p>${errors.invalidLink}</p>
      </div>
    </c:if>
    Nové heslo: <input type="text" name="password"/>
    Potvrzení hesla: <input type="text" name="passwordVerification"/>
    <input type="submit" value="odeslat" />
</form>
<%@ include file="layout/footer.jsp" %>