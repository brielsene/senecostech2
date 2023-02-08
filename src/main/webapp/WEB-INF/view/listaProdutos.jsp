<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SENECOSTECH</title>
</head>
<body>

Lista de produtos: 
<br><br><br>

<c:forEach items="${listaProdutos }" var="lista">
<ul>
ID DO PRODUTO: ${lista.id }
NOME DO PRODUTO: ${lista.nome }
DESCRICAO: ${lista.descricao }
VALOR: ${lista.valor }
</ul>
</c:forEach>



</body>
</html>