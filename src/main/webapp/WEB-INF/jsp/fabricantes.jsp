<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.iesvegademijas.model.FabricanteDTO"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fabricantes</title>
<style>
.clearfix::after {
	content: "";
	display: block;
	clear: both;
}
</style>
</head>
<body>
<body>
	<%@ include file="/WEB-INF/jsp/header.jspf"%>
	<%@ include file="/WEB-INF/jsp/nav.jspf"%>
	<main>
		<section>
			<div id="contenedora"
				style="float: none; margin: 0 auto; width: 900px;">
				<div class="clearfix">
					<div style="float: left; width: 50%">
						<h1>Fabricantes</h1>
					</div>
					<div
						style="float: none; width: auto; overflow: hidden; min-height: 80px; position: relative;">

						<div style="position: absolute; left: 39%; top: 39%;">

							<form action="/tienda_informatica/fabricantes/crear">
								<input type="submit" value="Crear">
							</form>
							<form action="/tienda_informatica/fabricantes/">
								<select name="ordenar-por" style="float: left;">
									<%
									if (request.getAttribute("ordenar-por").equals("nombre")) {
									%>
									<option value="codigo">Código</option>
									<option value="nombre" selected>Nombre</option>
									<%
									} else {
									%>
									<option value="codigo" selected>Código</option>
									<option value="nombre">Nombre</option>
									<%
									}
									%>
								</select> <select name="modo-ordenar" style="float: left;">
									<%
									if (request.getAttribute("modo").equals("Desc")) {
									%>
									<option value="Asc">Asc</option>
									<option value="Desc" selected>Desc</option>
									<%
									} else {
									%>
									<option value="Asc" selected>Asc</option>
									<option value="Desc">Desc</option>
									<%
									}
									%>
								</select> <input type="submit" value="Ordenar" style="float: left;">
							</form>
						</div>

					</div>
				</div>
				<div class="clearfix">
					<hr />
				</div>
				<div class="clearfix">
					<div style="float: left; width: 25%">Código</div>
					<div style="float: left; width: 20%">Nombre</div>
					<div style="float: left; width: 25%">Productos</div>
					<div style="float: none; width: auto; overflow: hidden;">Acción</div>
				</div>
				<div class="clearfix">
					<hr />
				</div>
				<%
				if (request.getAttribute("listaFabricantes") != null) {
					List<FabricanteDTO> listaFabricante = (List<FabricanteDTO>) request.getAttribute("listaFabricantes");

					for (FabricanteDTO fabricanteDTO : listaFabricante) {
				%>

				<div style="margin-top: 6px;" class="clearfix">
					<div style="float: left; width: 25%"><%=fabricanteDTO.getCodigo()%></div>
					<div style="float: left; width: 25%"><%=fabricanteDTO.getNombre()%></div>
					<div style="float: left; width: 20%"><%=fabricanteDTO.getProductos()%></div>
					<div style="float: none; width: auto; overflow: hidden;">
						<form
							action="/tienda_informatica/fabricantes/<%=fabricanteDTO.getCodigo()%>"
							style="display: inline;">
							<input type="submit" value="Ver Detalle" />
						</form>
						<form
							action="/tienda_informatica/fabricantes/editar/<%=fabricanteDTO.getCodigo()%>"
							style="display: inline;">
							<input type="submit" value="Editar" />
						</form>
						<form action="/tienda_informatica/fabricantes/borrar/"
							method="post" style="display: inline;">
							<input type="hidden" name="__method__" value="delete" /> <input
								type="hidden" name="codigo"
								value="<%=fabricanteDTO.getCodigo()%>" /> <input type="submit"
								value="Eliminar" />
						</form>
					</div>
				</div>

				<%
				}
				} else {
				%>
				No hay registros de fabricante
				<%
				}
				%>
			</div>
		</section>
	</main>
	<%@ include file="/WEB-INF/jsp/footer.jspf"%>
</body>
</body>
</html>