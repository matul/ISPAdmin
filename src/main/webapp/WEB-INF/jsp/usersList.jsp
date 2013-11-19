<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Seznam uživatelů</title>
    <style type="text/css">
      table {width: 100%; border-collapse: collapse; border: 1px solid #CCC; font-size: 12px; border-radius: 5px; -moz-border-radius: 5px; -webkit-border-radius: 5px;}
      table tr th, table tr td {border: 1px solid #CCC; padding: 4px;}
      table tr th {background: #E2F1F1; text-align: left; font-weight: bold;}
      table tr td {background: #F4FAFA;}
      table tr td a {text-decoration: none; color: blue;}
      table tr td a:hover {text-decoration: underline; color: #2E4C6C;}
    </style>
  </head>
  <body>
    <h1>Seznam uživatelů</h1>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Uživatelské jméno</th>
          <th>Jméno</th>
          <th>Příjmení</th>
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
              </tr>
            </c:forEach>
          </c:when>
          <c:otherwise>
            <tr> 
              <td colspan="5">Nebyli nalezení žádní uživatelé</td> 
            </tr> 
          </c:otherwise>     
        </c:choose>
      </tbody>
    </table>
  </body>
</html>
