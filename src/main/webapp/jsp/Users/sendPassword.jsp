<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../resources/media/siteAdmin.css" rel="stylesheet" type="text/css" /> 
        <link href="../resources/media/images.css" rel="stylesheet" type="text/css" />
        <title>Zaslání hesla</title>
    </head>
    <body id="login">
        <div class="all">        
            <div class="loginheader">          
                <div class="logindiv">            
                    <div class="in"><h2>Obnova hesla</h2>
                        ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}

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
