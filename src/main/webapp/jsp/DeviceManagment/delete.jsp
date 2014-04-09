<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
<h2>Smazání zařízení</h2>
<%@ include file="submenu.jsp" %>
<form:form method="POST" action="${action}" modelattribute="device" commandName="device">

  <label>Opravdu si přejete smazat toto zařízení?</label>

  <input type="submit" name="submitYes" value="Ano" />
  <input type="submit" name="submitNo" value="Ne" />
</form:form>
<%@ include file="../footer.jsp" %>
