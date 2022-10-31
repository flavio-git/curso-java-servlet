<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="com.flavio.gerenciador.model.Empresa"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Standard Taglib</title>
</head>
<body>
	<h2>Empresas cadastradas no sistema</h2>
	<ul>
		<c:forEach items="${empresasCadastradas}" var="empresa">
			<li>
				<strong> id: </strong> ${empresa.id} | 
				<strong> nome: </strong> ${empresa.nome} | 
				<strong> abertura: </strong> <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> |
				<a href="entrada?acao=EditaEmpresa&id=${empresa.id }">editar</a> 
				<a href="entrada?acao=RemoveEmpresa&id=${empresa.id }">deletar</a>
			</li>
		</c:forEach>
	</ul>
	<a href="entrada">voltar</a>
</body>
</html>

