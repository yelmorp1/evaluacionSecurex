<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
	
		<script type="text/javascript">
			function remove() {
				var opcion = confirm("Esta seguro de Eliminar el Registro?");
				if (opcion == true) {
					return true;
				} else {
					return false;
				}
			}
		</script>
		<style>
			#trtable:hover{
				background-color: #D3D3D3;
			}
		</style>
	</head>
	<body>
		<a style="margin: 20px 0 20px 20px;" href="/genticket" class="btn btn-success btn-sm">Regresar al Generador de Tickets</a>
		<!-- <a style="margin: 0px 0 10px 0;" class="btn btn-outline-success btn-sm" href="/">Atras</a> -->
		<div class="table-responsive" style="margin-left:20px;height: 400px; width: 800px; overflow-y: scroll; border-left: 1px solid #E9ECEF;">
			<table id="ntable" style="font-size: 13px;" class="table table-sm table-striped">
				<thead style="background-color: grey; color: white;">
					<tr>
						<th scope="col">ID Usuario</th>
						<th scope="col">Nombre Cajeros</th>
						<th scope="col">Exclusivo</th>
						<th scope="col">Normal</th>
						<th scope="col">Atencion Preferencial</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuList}" var="row">
						<tr id ="trtable" style="border-bottom: 1px solid #CCCDCF;">
							<td><c:out value="${row.idCajero}" /></td>
							<td><c:out value="${row.usuario}" /></td>
							<td><c:out value="" /><a class="btn ${row.claseBoot1} btn-sm" >${row.excl}</a></td>
							<td><c:out value="" /><a class="btn ${row.claseBoot2} btn-sm" >${row.normal}</a></td>
							<td><c:out value="" /><a class="btn ${row.claseBoot3} btn-sm" >${row.atencionpref}</a></td>
		
							<!--  <td>
								<a class="badge badge-pill badge-warning" href="/edit@${row.id_usuario}">Editar</a>
								<a class="badge badge-pill badge-danger" onclick='return remove()' href="/delete@${row.id_usuario}">Borrar</a>
							</td>-->
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>	
