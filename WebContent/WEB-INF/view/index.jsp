<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Sistema de cadastro</h1>
	<h3>Bem vindo: ${usuarioLogado.login}</h3>
	<nav>
		<a href="entrada?acao=NovaEmpresaForm">Cadastrar Nova Empresa</a>
		<a href="entrada?acao=EmpresasCadastradas">Empresas Cadastradas</a>
	</nav>
	<a href="entrada?acao=Logout">Logout</a>
</body>
</html>