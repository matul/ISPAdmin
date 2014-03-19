<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<h2>Seznam klientů</h2>  

<div id="demo_jui">
  <table id="companies" class="display">
    <thead>
      <tr>
        <th>ID</th>
        <th>Uživatelské jméno</th>
        <th>Jméno</th>
        <th>Příjmení</th>
        <th>Město</th>
        <th>Ulice</th>
        <th>Poštovní číslo</th>
        <th>Email</th>
        <th>Telefon</th>
        <th>Datum narození</th>
      </tr>
    </thead>
    <tbody>
      <c:choose>
        <c:when test="${!empty users}">
          <c:forEach items="${users}" var="u">
            <tr>
              <td>${u.getId()}</td>
              <td>${u.getUsername()}</td>
              <td>${u.getFirstname()}</td>
              <td>${u.getSurname()}</td>
              <td>${u.getCity()}</td>
              <td>${u.getStreet()}</td>
              <td>${u.getPost_code()}</td>
              <td>${u.getEmail()}</td>
              <td>${u.getPhone_number()}</td>
              <td>${u.getBirthDate()}</td>
              <td><a href="/ispadmin/users/edit/">${u.getId()}Upravit</a></td> 
            </tr>
          </c:forEach>
        </c:when>
      </c:choose>
    </tbody>
  </table>
</div>
<%@ include file="footer.jsp" %>             
