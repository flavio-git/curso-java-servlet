<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<form action="entrada?acao=Login" method="post">
		<label for="login">login</label>
		<input id="login" type="text" name="login" required="required">
		
		<label for="senha">senha</label>
		<input id="senha" type="password" name="senha" required="required">
	
		<input type="submit">
	
	</form>
</body>
</html>