<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
<h2>Správa zařízení</h2>  
<%@ include file="submenu.jsp" %>
<div id="demo_jui">
  <table id="companies" class="display">
    <thead>
      <tr>
        <th>Id faktury</th>
        <th>Id uživatele</th>
        <th>Uživatelské jméno</th>
        <th>Datum vystavení</th>
        <th>Datum splatnosti</th>
        <th>Cena</th>
        <th>Stav</th>
        <th>Upravit</th>
        <th>Smazat</th>
      </tr>
    </thead>
    <tbody>
     <c:choose>
        <c:when test="${!empty invoices}">
          <c:forEach items="${invoices}" var="d">
            <tr>
              <td>${d.getId()}</td>
              <td>${d.getUser().getId()}</td>
              <td>${d.getUser().getUsername()}</td>
              <td>${d.getIssueDate()}</td>
              <td>${d.getDueDate()}</td>
              <td>${d.getPrice()}</td>
              <td>${d.getState().getState()}</td>
              <td>
                <a class="image editUsers" href="${editLink}/${d.getId()}" title="upravit"></a>
              </td>
              <td>
                <a class="image deleteUsers" href="${deleteLink}/${d.getId()}" title="odstranit"></a>
              </td>
            </tr>
          </c:forEach>
        </c:when>
      </c:choose>
    </tbody>
  </table>
</div>
<%@ include file="../footer.jsp" %>
