<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.iesvegademijas.model.Fabricante"%>
<%@page import="java.util.Optional"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle Usuario</title>
<style>
.clearfix::after {
	content: "";
	display: block;
	clear: both;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jspf"%>
	<%@ include file="/WEB-INF/jsp/nav.jspf"%>
	<main>
		<section>
			<div id="contenedora"
				style="float: none; margin: 0 auto; width: 900px;">
				<form action="/tienda_informatica/usuarios/crear/" method="post">
					<div class="clearfix">
						<div style="float: left; width: 50%">
							<h1>Crear Usuario</h1>
						</div>
						<div
							style="float: none; width: auto; overflow: hidden; min-height: 80px; position: relative;">

							<div style="position: absolute; left: 39%; top: 39%;">
								<input type="submit" value="Crear" />
							</div>

						</div>
					</div>

					<div class="clearfix">
						<hr />
					</div>

					<div style="margin-top: 6px;" class="clearfix">
						<div style="float: left; width: 50%">Usuario</div>
						<div style="float: none; width: auto; overflow: hidden;">
							<input name="usuario" />
						</div>
					</div>

					<div style="margin-top: 6px;" class="clearfix">
						<div style="float: left; width: 50%">Password</div>
						<div style="float: none; width: auto; overflow: hidden;">
							<input name="password" />
						</div>
					</div>

					<div style="margin-top: 6px;" class="clearfix">
						<div style="float: left; width: 50%">Rol</div>
						<div style="float: none; width: auto; overflow: hidden;">
							<select name="rol">
								<option value="cliente" selected>Cliente</option>
								<option value="vendedor">Vendedor</option>
								<option value="administrador">Administrador</option>
							</select>
						</div>
					</div>
				</form>
			</div>
		</section>
	</main>
	<%@ include file="/WEB-INF/jsp/footer.jspf"%>
</body>
</html>