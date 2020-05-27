<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Listar países</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="./css/bootstrap.min.css">
	</head>
	
	<body class="bg-dark text-white">
		<c:import url="Menu.jsp"/>
		<!-- Modal -->
            <div class="modal fade text-dark" id="delete-modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="modalLabel">Excluir País</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Deseja realmente excluir este país?
                        </div>
                        <div class="modal-footer">
                            <form action="ManterPais.do" method="post">
                                <input type="hidden" name="id" id="id_excluir" value=""/>
                                <button type="submit" class="btn btn-primary" name="acao" value="excluir">Sim</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">N&atilde;o</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- Container Principal -->
            <div id="main" class="container">
                <form action="ListarPaises.do" method="post">
                    <div id="top" class="row">
                        <div class="col-md-3">
                            <h2>Países</h2>
                        </div>

                        <div class="col-md-6">
                            <div class="input-group h2">
                                <input name="chave" class="form-control" id="search" type="text" placeholder="Pesquisar países (deixe vazio para trazer todos)">
                                <span class="input-group-btn">
				                <button class="btn btn-primary" type="submit" name="acao" value="buscar">
				                    buscar
                                </button>
                                </span>
                            </div>
                        </div>
                    </div>
                    <!-- /#top -->
                </form>
                <hr class="border-light"/>
                <c:if test="${not empty lista}">
               	<div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Nome</th>
                                    <th>População</th>
                                    <th>Área</th>
                                    <th class="actions">Ações</th>
                                </tr>
                            </thead>
                            <tbody>
          					<c:forEach var="pais" items="${lista}">
                                       <tr>
                                            <td>${pais.id}</td>
                                            <td>${pais.nome}</td>
                                            <td>${pais.populacao}</td>
                                            <td>${pais.area }</td>
                                            <td class="actions">
                                                <a class="btn btn-success btn-xs" href="ManterPais.do?acao=visualizar&id=${pais.id}">Visualizar</a>
                                                <a class="btn btn-warning btn-xs" href="ManterPais.do?acao=editar&id=${pais.id}">Editar</a>
                                                <button id="btn${pais.id}%>" type="button" class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete-modal" data-pais="${pais.id}">Excluir</button>
                                            </td>
                                        </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- /#list -->

                <div id="bottom" class="row">
                    <div class="col-md-12">
                        <!-- paginação ainda não foi implementada -->
                        <ul class="pagination">
                            <li class="disabled"><a>&lt; Anterior</a>
                            </li>
                            <li class="disabled"><a>1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li class="next"><a href="#" rel="next">Próximo &gt;</a>
                            </li>
                        </ul>
                        <!-- /.pagination -->
                    </div>
                </div>
               	</c:if>
                <!-- /#bottom -->
            </div>
            <!-- /#main -->
            <script src="js/jquery-3.5.1.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script type="text/javascript">
                $("#delete-modal").on('show.bs.modal', function(event) {
                	console.log("sasasfsaf")
                    var button = $(event.relatedTarget); //botao que disparou a modal
                    var recipient = button.data('pais');
                    console.log("button" + button + "   recipient" + recipient)
                    $("#id_excluir").val(recipient);
                });
            </script>
	</body>
</html>