<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Editando empresa
	</h1>
	
	<strong> id: </strong> ${empresa.id} | 
	<strong> nome: </strong> ${empresa.nome} | 
	<strong> abertura: </strong> <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
	
	<h3>Insira os novos valores abaixo: </h3>
	
	<form action="entrada?acao=ModificaEmpresa" method="post">
		<label for="nome-empresa">Nome: </label>
		<input id="nome-empresa" name="nome" type="text" value="${empresa.nome }">
		<br>
		<label for="data-abertura">Data de abertura: </label>
		<input id="data-abertura" name="abertura" type="date" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="yyyy-MM-dd"/>">
		<input name="id" type="hidden" value="${empresa.id }" /> 
		<input type="submit">
	</form>
	
	<a href="entrada?acao=EmpresasCadastradas">voltar</a>
	
</body>
</html>