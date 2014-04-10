<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../header.jsp" %>
<h2>Nový tiket</h2>
<%@ include file="submenu.jsp" %>
<form:form method="POST" action="${action}" modelattribute="incident" commandName="incident">
    <label class="bugReport">Předmět problému: ${incident.getSubject()}</label>

    <label class="bugReport">Popis: ${incident.getMessage()}</label>

    <label>Změna stavu:</label>
    <form:select path="state.id">
        <c:forEach items="${states}" var="s">
            <form:option value="${s.getId()}" label="${s.getState()}" />
        </c:forEach>
    </form:select>
    <form:errors path="state.id" class="error"></form:errors>

    <label>Odpověď:</label>
    <form:textarea path="answer"></form:textarea>
    <form:errors path="answer" class="error"></form:errors>
    <div class="clear"></div>
    <input type="submit" name="submit" value="Odeslat" class="submit left" />
    <a href="${leaveLink}" class="submit left">Zrušit</a>
</form:form>
<%@ include file="../footer.jsp" %>
