<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
	</head>
	<body>
		<f:form method="POST" modelAttribute="usuario" action="/ingresarAlTicket">
			<div class="card">
				<div style="background-color:grey; color:white; height: 35px; font-size:15px; padding-top:7px;" class="card-header">Generar Ticket</div>
				<div class="card-body">
			
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-form-label-sm" for="user">Nombre:(*)</label>
							<div class="col-md-2">
								<f:input type="text" path="user"
									cssClass="form-control form-control-sm" required="true" />
								<div class="has-error">
									<f:errors path="user" class="help-inline" />
								</div>
							</div>
						</div>
						<div class="form-group col-md-12">
							<label class="col-form-label-sm" for="edad">Edad:(*)</label>
							<div class="col-md-1">
								<f:input type="text" path="edad"
									cssClass="form-control form-control-sm" required="true"/>
								<div class="has-error">
									<f:errors path="user" class="help-inline" />
								</div>
							</div>
						</div>
					</div>
					<!-- <div class="row">
						<div class="form-group col-md-12">
							<label class="col-form-label-sm" for="pass">Password:(*)</label>
							<div class="col-md-3">
								<f:input type="password" path="pass"
									cssClass="form-control form-control-sm" />
								<div class="has-error">
									<f:errors path="pass" class="help-inline" />
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-form-label-sm" for="descripcion">Descripcion:(*)</label>
							<div class="col-md-4">
								<f:input type="text" path="descripcion"
									cssClass="form-control form-control-sm" />
								<div class="has-error">
									<f:errors path="descripcion" class="help-inline" />
								</div>
							</div>
						</div>
					</div>-->
				</div>
			</div>
			<br>
			<div style="margin-left:10px;" class="row">
				<div class="form-group col-md-12">
					<input type="submit" value="Generar Ticket" class='btn btn-success btn-sm' />
					<!--  <a class="btn btn-outline-success btn-sm" href="/listUsuarios">Atras</a>-->
				</div>
			</div>			
		</f:form>
	</body>
</html>	
