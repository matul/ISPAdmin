<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Přihlášení do systému</title>
  </head>
  <body>
    <h1>Přihlášení</h1>
    <form method="POST" action="/login/submit">
      <label>Uživatelské jméno</label>
      <input name="username" type="text" />
      <label>Heslo</label>
      <input name="password" type="password" />
      <input type="submit" name="submit" value="Přihlásit se" />
    </form>
  </body>
</html>
