<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		Resultado da Pesquisa:
		<ul>
			<c:forEach items="${empresas }" var="empresa">
				<li>${empresa.id}: ${empresa.nome}</li>
			</c:forEach>
		</ul>
	</body>
</html>