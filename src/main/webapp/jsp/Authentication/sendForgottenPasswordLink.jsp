<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../resources/media/siteAdmin.css" rel="stylesheet" type="text/css" /> 
        <link href="../resources/media/images.css" rel="stylesheet" type="text/css" />
        <title>Zaslání odkazu pro obnovu hesla</title>
    </head>
    <body id="login">
        <div class="all">        
            <div class="loginheader">          
                <div class="logindiv">            
                    <div class="in"><h2>Zaslání odkazu pro obnovu hesla</h2>
                        <c:if test="${not empty errors.userNotFound}">
                            <div class="msg error">
                                <p>${errors.userNotFound}</p>                 
                            </div>
                        </c:if>
                        <c:if test="${not empty errors.emailVerification}">
                            <div class="msg error">
                                <p>${errors.emailVerification}</p>
                            </div>
                        </c:if>
                        <form action="${action}" method="post" property="userame" name="sendPassword">
                            
                            <label>Uživatelské jméno</label>
                            <input type="text" name="username"/>
                            
                            <label>Email</label>
                            <input type="text" name="email"/>

                            <input name="submit" type="submit" value="Odeslat" class="submit" />   
                        </form> 
                    </div>          
                </div>        
            </div>      
        </div>
    </body>
</html>
