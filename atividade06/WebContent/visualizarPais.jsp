<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.Pais" %>

<!DOCTYPE html>
<html>
	<head>
		<title>País cadastrado</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="./css/bootstrap.min.css">
		<link rel="stylesheet" href="./css/style.css">
	</head>
	
	<body class="bg-dark text-white">
		<c:import url="Menu.jsp"/>
			
		<div class="container">
			<h1 class="mt-4 mb-4">País cadastrado com sucesso!</h1>
			
			<h3><span class="badge badge-info mr-2">ID:</span>${pais.id}</h3>
			<h3><span class="badge badge-info mr-2">Nome:</span>${pais.nome}</h3>
			<h3><span class="badge badge-info mr-2">População:</span>${pais.populacao}</h3>
			<h3><span class="badge badge-info mr-2">Área:</span>${pais.area}</h3>
		</div>
		
		
		<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="./js/bootstrap.min.js"></script>
	</body>
</html>