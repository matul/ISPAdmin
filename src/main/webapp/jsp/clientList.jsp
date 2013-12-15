<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <base href="http://localhost:8080/ispadmin/" />
        <title>Applying JQuery DataTables plugin in the Java Server application</title>
        <link href="resources/media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="resources/media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="resources/media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="resources/media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="resources/media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />
        <script src="resources/scripts/jquery.js" type="text/javascript"></script>
        <script src="resources/scripts/jquery.dataTables.min.js" type="text/javascript"></script>
        <script type="text/javascript">
        $(document).ready(function () {
            $("#companies").dataTable({
                "sPaginationType": "full_numbers",
                "bJQueryUI": true
            });
        });
        </script>
    </head>
    <body id="dt_example">
        <div id="container">

            <div id="demo_jui">
              <table id="companies" class="display">
                  <thead>
                      <tr>
                          <th>Sranda</th>
                          <th>Company name</th>
                          <th>Address</th>
                          <th>Town</th>
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
                    </c:choose>
                  </tbody>
              </table>
            </div>
        </div>
    </body>
</html>
