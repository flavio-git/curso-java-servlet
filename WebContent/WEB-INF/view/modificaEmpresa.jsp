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
	<h1>Empresa modificada</h1>
	
	<strong> id: </strong> ${id} | 
	<strong> nome: </strong> ${nome} | 
	<strong> abertura: </strong> ${data}
	
	<a href="entrada">voltar</a>
	
</body>
</html>