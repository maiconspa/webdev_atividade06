<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<nav class="navbar navbar-dark bg-primary navbar-expand-lg">
		  <a class="navbar-brand">PAÍSES</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  <div class="collapse navbar-collapse" id="navbarNav">
		    <ul class="navbar-nav">
		      <li class="nav-item active">
		        <a class="nav-link" href="index.html">Cadastro</a>
		      </li>
		    </ul>
		  </div>
		</nav>
			
		<div class="container">
			<%Pais pais = (Pais) request.getAttribute("pais"); %>
			
			<h1 class="mt-4 mb-4">País cadastrado com sucesso!</h1>
			
			<h3><span class="badge badge-info mr-2">ID:</span><%=pais.getId() %></h3>
			<h3><span class="badge badge-info mr-2">Nome:</span><%=pais.getNome() %></h3>
			<h3><span class="badge badge-info mr-2">População:</span><%=pais.getPopulacao() %></h3>
			<h3><span class="badge badge-info mr-2">Área:</span><%=pais.getArea() %></h3>
		</div>
		
		
		<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="./js/bootstrap.min.js"></script>
	</body>
</html>