<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de productos</title>

<style>
table {
	border-collapse: collapse;
	width: 75%;
}

th {
	font-weight: lighter;
	text-shadow: 0 1px 0 #38678f;
	color: white;
	background: steelblue;
}

th, td {
	padding: 6px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

tr:hover {
	background-color: #f5f5f5;
}
</style>
</head>
<body>
	<h2>Productos</h2>

	<a href="insertar.jsp">Insertar nuevo producto</a>
	<br><br>

	<table>
		<tr>
			<th>Codigo</th>
			<th>Seccion</th>
			<th>Articulo</th>
			<th>Precio</th>
			<th>Fecha</th>
			<th>Importado</th>
			<th>Pais</th>
			<th>Accion</th>
		</tr>
		<s:iterator value="lista" var="prod">
			<tr>
				<td><s:property value="codArt" /></td>
				<td><s:property value="seccion" /></td>
				<td><s:property value="nombreArt" /></td>
				<td><s:property value="precio" /></td>
				<td><s:property value="fecha" /></td>
				<td><s:property value="importado" /></td>
				<td><s:property value="pais" /></td>
				<!-- Buen momento para usar el tag de URL para pasar parametros -->
				<s:url action="eliminarProducto" var="eliminarLink">
					<s:param name="codArtActual"> ${codArt} </s:param>
				</s:url>
				
				<s:url action="actualizarProducto" var="actualizarLink">
					<s:param name="codArtActual"> ${codArt} </s:param>
				</s:url>
				<td><a href="${actualizarLink}">Editar</a> / <a href="${eliminarLink}">Eliminar</a></td>
			</tr>
		</s:iterator>
	</table>


</body>
</html>