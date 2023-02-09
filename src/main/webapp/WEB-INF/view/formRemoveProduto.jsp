<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
/* Estilização da página */
body {
	font-family: Arial, sans-serif;
	padding: 30px;
}

/* Estilização do título */
h1 {
	text-align: center;
	margin-bottom: 50px;
}

/* Estilização do formulário */
form {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-bottom: 50px;
}

/* Estilização dos inputs */
input[type="text"], input[type="number"] {
	padding: 10px;
	font-size: 16px;
	margin-bottom: 20px;
	width: 300px;
}

/* Estilização do botão de envio */
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
	<h1>Remoção de produto</h1>
	<form action="/senecostech/controller?acao=RemoveProduto" method="post">
		<input type="text" value="${produto.nome }" readonly/>
		<input type="text" value="${produto.descricao }" readonly/>
		<input type="text" value="${produto.valor }" readonly/>
		<input type="text" value="${produto.id }" readonly/>
		<input type="hidden" name ="id" value="${produto.id }"/>
		<input type="submit" value="Remover">
	</form>
</body>
</html>