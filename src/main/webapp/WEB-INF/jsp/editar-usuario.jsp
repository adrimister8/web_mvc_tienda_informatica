<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.iesvegademijas.model.Usuario"%>
<%@page import="java.util.Optional"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle usuario</title>
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
				<form action="/tienda_informatica/usuarios/editar/" method="post">
					<input type="hidden" name="__method__" value="put" />
					<div class="clearfix">
						<div style="float: left; width: 50%">
							<h1>Editar usuario</h1>
						</div>
						<div
							style="float: none; width: auto; overflow: hidden; min-height: 80px; position: relative;">

							<div style="position: absolute; left: 39%; top: 39%;">
								<input type="submit" value="Guardar" />
							</div>

						</div>
					</div>

					<div class="clearfix">
						<hr />
					</div>

					<%
					Optional<Usuario> optUsu = (Optional<Usuario>) request.getAttribute("usuario");
					if (optUsu.isPresent()) {
					%>

					<div style="margin-top: 6px;" class="clearfix">
						<div style="float: left; width: 50%">
							<label>Código</label>
						</div>
						<div style="float: none; width: auto; overflow: hidden;">
							<input name="codigo" value="<%=optUsu.get().getCodigo()%>"
								readonly="readonly" />
						</div>
					</div>
					<div style="margin-top: 6px;" class="clearfix">
						<div style="float: left; width: 50%">
							<label>Usuario</label>
						</div>
						<div style="float: none; width: auto; overflow: hidden;">
							<input name="nombre" value="<%=optUsu.get().getUsuario()%>" />
						</div>
					</div>
					<div style="margin-top: 6px;" class="clearfix">
						<div style="float: left; width: 50%">
							<label>Password</label>
						</div>
						<div style="float: none; width: auto; overflow: hidden;">
							<input name="password" value="" />
						</div>
					</div>
					<div style="margin-top: 6px;" class="clearfix">
						<div style="float: left; width: 50%">
							<label>Rol</label>
						</div>
						<div style="float: none; width: auto; overflow: hidden;">
							<input name="codigo_fabricante"
								value="<%=optUsu.get().getRol()%>" />
						</div>
					</div>


					<%
					} else {
					%>

					request.sendRedirect("usuarios/");

					<%
					}
					%>
				</form>
			</div>
		</section>
	</main>
	<%@ include file="/WEB-INF/jsp/footer.jspf"%>
</body>
</html>