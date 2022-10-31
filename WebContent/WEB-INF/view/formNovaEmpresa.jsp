<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="nova-empresa" var="linkNovaEmpresaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrando nova empresa</title>
</head>
<body>
	<h1>Cadastrando uma nova empresa</h1>
	<form action="entrada?acao=NovaEmpresa" method="post">
		<label for="nome-empresa">Nome: </label>
		<input id="nome-empresa" name="nome" type="text" required="required">
		<br>
		<label for="data-abertura">Data de abertura: </label>
		<input id="data-abertura" name="abertura" type="date" required="required">
		<input type="submit">
	</form>
	<a href="entrada">voltar</a>
</body>
</html>