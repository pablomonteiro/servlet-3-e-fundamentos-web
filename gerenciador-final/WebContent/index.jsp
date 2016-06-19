<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<body>
		Bem-vindo ao nosso gerenciador de empresas!<br/>
		<c:if test="${not empty usuarioLogado}">
			Logado como ${usuarioLogado}.
		</c:if>
		<form action="executa" method="post">
			<input type="hidden" name="tarefa" value="NovaEmpresa" />
			Nome: <input type="text" name="nome"/>
			<input type="submit" value="Enviar"/>
		</form>
		<form action="login" method="post">
			Email: <input type="text" name="email"/>
			Senha: <input type="password" name="senha"/>
			<input type="submit" value="Enviar"/>
		</form>
		<form action="executa" method="post">
			<input type="hidden" name="tarefa" value="Logout" />
		    <input type="submit" value="Logout" />
		</form>
		<form action="executa" method="post">
			<input type="hidden" name="tarefa" value="BuscaEmpresa" />
			Nome da Empresa: <input type="text" name="nome"/>
		    <input type="submit" value="Pesquisar" />
		</form>
		
	</body>
</html>