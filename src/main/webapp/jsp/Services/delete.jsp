<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
<h2>Smazání služby</h2>
<%@ include file="submenu.jsp" %>
<form:form method="POST" action="${action}" modelattribute="device" commandName="device">

  <label>Opravdu si přejete smazat tuto službu?</label>

  <input type="submit" name="submitYes" value="Ano" class="submit left" />
  <input type="submit" name="submitNo" value="Ne" class="submit left" />
</form:form>
<%@ include file="../footer.jsp" %>
