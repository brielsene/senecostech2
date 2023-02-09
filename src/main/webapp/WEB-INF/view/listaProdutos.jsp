<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SENECOSTECH</title>
</head>

<style>
  ul {
    list-style: none;
    margin: 0;
     padding: 75px;
    background-color: #20B2AA;
   
    border: 1px solid black;
    margin-bottom: 10px;
  }

  .product-id {
    font-weight: bold;
  }

  .product-name {
    font-size: 1.2em;
  }

  .product-description {
    margin-top: 10px;
  }

  .product-value {
  text-shadow: 2px 2px black;
    float: right;
    font-weight: bold;
    color: white;
    
    
  }
  
  h2{
  	text-align: center;
  }
  
  .edit-button{
  padding: 15px;
  }
  
  
</style>
<body>


<h2>Lista de produtos: </h2>

<br><br><br>

<c:forEach items="${listaProdutos }" var="lista">
<ul>
<div class ="product-id"> ID DO PRODUTO: ${lista.id }</div>
<div class ="product-name">NOME DO PRODUTO: ${lista.nome }</div>
<div class ="product-description">DESCRICAO: ${lista.descricao }</div>
<div class ="product-value">VALOR: ${lista.valor } R$</div>
<a href="/senecostech/controller?acao=MostraProdutos&id=${lista.id }">Editar</a>
<a href="/senecostech/controller?acao=FormRemocao&id=${lista.id }">Remover</a>
</ul>
</c:forEach>

</form>



</body>
</html>