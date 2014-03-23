<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Přihlášení</title>
  </head>
  <body>
    <h1>Přihlášení</h1>
    ${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}
    
    <form name='f' action='/ispadmin/j_spring_security_check' method='POST'>
      <table>  
        <tr>  
          <td>User:</td>  
          <td><input type='text' name='j_username' >  
          </td>  
        </tr>  
        <tr>  
          <td>Password:</td>  
          <td><input type='password' name='j_password' />  
          </td>  
        </tr>  
        <tr>  
          <td colspan='2'><input name="submit" type="submit"  
                                 value="submit" />  
          </td>  
        </tr>  
        <tr>  
          <td colspan='2'><input name="reset" type="reset" />  
          </td>  
        </tr>  
      </table>  
    </form>  
  </body>
</html>
