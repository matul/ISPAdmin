<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <base href="http://localhost:8080/ispadmin/" />
        <title>Applying JQuery DataTables plugin in the Java Server application</title>
        <link href="resources/media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />
        <link href="../media/datedit.css" rel="stylesheet" type="text/css" />
        <link href="../media/site.css" rel="stylesheet" type="text/css" />
        <link href="../media/images.css" rel="stylesheet" type="text/css" />
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
        <div class="all">        
      <div class="allin">                     
        <div class="header">        
          <div class="topline">          
            <div class="user">Přihlášený uživatel: admin</div>          
            <div class="logouttimer">                      
            </div>        
          </div>                 
          <div class="bigicons">          
            <div class="left">            
              <!-- -->          
            </div>          
            <div class="right">                
              <ul>      
                <li>
                <a href="#" target="_blank" class="preview" title="Zobrazí náhled webu v novém panelu prohlížeče">Náhled stránek</a>
                </li>            
                <li>
                <a href="#" class="websetting">Nastavení webu</a>
                </li>                  
                <li>
                <a href="#" class="user">Můj profil</a>
                </li>            
                <li>
                <a href="#" class="password">Změnit heslo</a>
                </li>      
                <li>
                <a href="#" class="logoff">Odhlásit se</a>
                </li>    
              </ul>                 
            </div>          
            <div class="clear">          
            </div>        
          </div>        
          <div class="menu">                
            <ul class="left">                          
              <li>
                <a href="#">Záložka</a>
              </li>  
              <li>
                <a href="#">Záložka</a>
              </li>  
              <li>
                <a href="#">Záložka</a>
              </li>  
              <li>
                <a href="#">Záložka</a>
              </li>  
              <li>
                <a href="#">Záložka</a>
              </li>  
              <li>
                <a href="#">Záložka</a>
              </li>  
              <li>
                <a href="#">Záložka</a>
              </li>  
            </ul>          
            <div class="clear">
              <!-- -->
            </div>               
          </div>      
        </div>          
        <div class="wrap">        
          <div class="content">          
            <div class="top">            
              <div class="bottom">                               
                <div id="modulesdropdown" class="hide">    
                    <div id="container">          
                        <div id="systemmsg"></div>
                        <h2>Nadpis</h2>  

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
                    </div>                   
                  </div>          
                </div>        
              </div>      
            </div>                
            <div class="footer">
              <!-- -->    
            </div>           
          </div>      
        </div>
    </body>
</html>
