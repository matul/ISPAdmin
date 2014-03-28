<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="http://localhost:8080/ispadmin/" />
    <title>${headline}</title>
    <link href="resources/media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
    <link href="resources/media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
    <link href="resources/media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
    <link href="resources/media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />
    <link href="resources/media/datedit.css" rel="stylesheet" type="text/css" />
    <link href="resources/media/site.css" rel="stylesheet" type="text/css" />
    <link href="resources/media/images.css" rel="stylesheet" type="text/css" />
    <script src="resources/scripts/jquery.js" type="text/javascript"></script>
    <script src="resources/scripts/jquery.dataTables.min.js" type="text/javascript"></script>
    <script type="text/javascript">
      $(document).ready(function() {
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
          </div>                 
          <div class="bigicons">          
            <img src="resources/media/images/brs.png" class="header-logo" alt="logo"/>         
            <div class="right">                
              <ul>      
                <li>
                  <a href="#" target="_blank" class="preview" title="Zobrazí náhled webu v novém panelu prohlížeče">Náhled stránek</a>
                </li>              
                <li>
                  <a href="#" class="user">Můj profil</a>
                </li>            
                <li>
                  <a href="/ispadmin/users/changePassword" class="password">Změnit heslo</a>
                </li>      
                <li>
                  <a href="/ispadmin/authentication/logout" class="logoff">Odhlásit se</a>
                </li>    
              </ul>                 
            </div>          
            <div class="clear">          
            </div>        
          </div>        
          <div class="menu">                
            <ul class="left">                          
              <li>
                <a href="/ispadmin/users/list">Správa klientů</a>
              </li>  
              <li>
                <a href="#">Fakturace</a>
              </li>  
              <li>
                <a href="#">Služby ISP</a>
              </li>  
              <li>
                <a href="#">Správa zařízení</a>
              </li>  
              <li>
                <a href="/ispadmin/serviceDesk/list">Service desk</a>
              </li>  
              <li>
                <a href="#">Autentizace</a>
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
