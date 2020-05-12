<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Cadastro de paÍses</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="./css/bootstrap.min.css">
		<link rel="stylesheet" href="./css/style.css">
	</head>
	
	<body class="bg-dark text-white">
		<c:import url="Menu.jsp"/>
		
		<div class="container">
			<h1 class="mt-4">CADASTRE UM PAÍS:</h1>
			
			<form action="./ManterPais.do" method="get">
				<div class="form-group">
	    			<label>Nome:</label>
				    <input type="text" class="form-control" name="nome">		  
				</div>
				<div class="form-group">
	    			<label>População:</label>
				    <input type="text" class="form-control" name="populacao">		  
				</div>
				<div class="form-group">
	    			<label>Área:</label>
				    <input type="text" class="form-control" name="area">		  
				</div>
				<button type="submit" class="btn btn-success">Salvar</button>
				<button type="reset" class="btn btn-danger">Limpar</button>
			</form>
		</div>
		
		
		<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>
		<script type="text/javascript" src="./js/bootstrap.min.js"></script>
	</body>
</html>