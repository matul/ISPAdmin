<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
<h2>Seznam problémů</h2>  
<%@ include file="submenu.jsp" %>
<div id="demo_jui">
  <table id="companies" class="display">
    <thead>
      <tr>
        <th>Předmět</th>
        <th>Popis</th>
        <th>Uživatelské jméno</th>
        <th>Jméno</th>
        <th>Příjmení</th>
        <th>Stav</th>
        <th>Odpověď</th>
        <th>Akce</th>
      </tr>
    </thead>
    <tbody>
      <c:choose>
        <c:when test="${!empty incidents}">
          <c:forEach items="${incidents}" var="i">
            <tr>
              <td>${i.getSubject()}</td>
              <td>${i.getMessage()}</td>
              <td>${i.getUser().getUsername()}</td>
              <td>${i.getUser().getFirstname()}</td>
              <td>${i.getUser().getSurname()}</td>
              <td>${i.getState().getState()}</td>
              <td>${i.getAnswer()}</td>
              <td>
                <a class="image edit" href="/ispadmin/serviceDesk/edit/${i.getId()}" title="upravit">upravit</a>
              </td> 
            </tr>
          </c:forEach>
        </c:when>
      </c:choose>
    </tbody>
  </table>
</div>
<%@ include file="../footer.jsp" %>
