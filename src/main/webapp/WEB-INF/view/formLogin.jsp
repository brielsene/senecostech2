<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <style>
      /* Estiliza��o da p�gina */
      body {
        font-family: Arial, sans-serif;
        padding: 30px;
      }

      /* Estiliza��o do t�tulo */
      h1 {
        text-align: center;
        margin-bottom: 50px;
      }

      /* Estiliza��o do formul�rio */
      form {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-bottom: 50px;
      }

      /* Estiliza��o dos inputs */
      input[type="text"],
      input[type="number"],
      input[type="password"] {
        padding: 10px;
        font-size: 16px;
        margin-bottom: 20px;
        width: 300px;
      }

      /* Estiliza��o do bot�o de envio */
      input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
      }
    </style>
  </head>
  <body>
    <h1>Login Administra��o</h1>
    <form action="/senecostech2/controller?acao=Login" method="post">
     	Login: <input type="text" name="login"/>
      	Senha: <input type="password" name = "senha"/>
      
      <input type="submit"  value="Login">
      <br><br><br>
      Caso n�o tenha login, <a href="/senecostech/controller?acao=FormCadastroUsuario">Cadastre-se</a>
    </form>
  </body>
</html>