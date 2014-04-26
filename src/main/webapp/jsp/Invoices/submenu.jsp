<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="http_base" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}/"/>
<c:set var="urlPrefix" value="${pageContext.request.secure ? fn:replace(http_base, ':443/', '/') : fn:replace(http_base, ':80/', '/')}"/>
<ul class="navigation">
  <li>
    <a href="${urlPrefix}invoices/add" class="image add">Nová faktura</a>
  </li>
  <li>
    <a href="${urlPrefix}invoices/list" class="image view">Seznam faktur</a>
  </li>
</ul>