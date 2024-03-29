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
        <th>Uživatelské jméno</th>
        <th>Jméno</th>
        <th>Příjmení</th>
        <th>Název zařízení</th>
        <th>Ip adresa</th>
        <th>MAC adresa</th>
        <th>Lokalizace</th>
        <th>Výrobce</th>
        <th>Model</th>
        <th>Upravit</th>
        <th>Smazat</th>
      </tr>
    </thead>
    <tbody>
     <c:choose>
        <c:when test="${!empty devices}">
          <c:forEach items="${devices}" var="d">
            <tr>
              <td>${d.getUser().getUsername()}</td>
              <td>${d.getUser().getFirstname()}</td>
              <td>${d.getUser().getSurname()}</td>
              <td>${d.getName()}</td>
              <td><a href="http://${d.getIpAdress()}">${d.getIpAdress()}</a></td>
              <td>${d.getMacAdress()}</td>
              <td>${d.getLocalization()}</td>
              <td>${d.getManufacturer()}</td>
              <td>${d.getModel()}</td>
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
