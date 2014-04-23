<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
<h2>Správa služeb</h2>  
<%@ include file="submenu.jsp" %>
<div id="demo_jui">
  <table id="companies" class="display">
    <thead>
      <tr>
        <th>Id služby</th>
        <th>Popis</th>
        <th>Název</th>
        <th>Cena</th>
        <th>Upravit</th>
        <th>Smazat</th>
      </tr>
    </thead>
    <tbody>
     <c:choose>
        <c:when test="${!empty service}">
          <c:forEach items="${service}" var="d">
            <tr>
              <td>${d.getId()}</td>
              <td>${d.getDescription()}</td>
              <td>${d.getName()}</td>
              <td>${d.getPrice()}</td>
              
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
