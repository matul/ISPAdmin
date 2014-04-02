<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <base href="http://localhost:8080/ispadmin/" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/media/siteAdmin.css" rel="stylesheet" type="text/css" /> 
        <link href="resources/media/images.css" rel="stylesheet" type="text/css" />
        <title>Zaslání odkazu pro obnovu hesla</title>
    </head>
    <body id="login">
        <div class="all">        
            <div class="loginheader">          
                <div class="logindiv">            
                    <div class="in">
                        <h2>Zadání nového hesla</h2>
                        <c:if test="${not empty success}">
                            <div class="msg ok">
                                <p>${success}</p>
                            </div>
                        </c:if>
                        
                        <form action="${action}" method="post" name="resetPassword">
                            <p>${errors.password}</p>
                            <p>${errors.passwordVerification}</p>
                            Nové heslo: <input type="text" name="password"/>
                            Potvrzení hesla: <input type="text" name="passwordVerification"/>
                            <input type="submit" value="odeslat" />
                            
                        </form>
                    </div>          
                </div>        
            </div>      
        </div>
    </body>
</html>
