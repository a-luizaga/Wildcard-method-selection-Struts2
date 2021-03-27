<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insertar nuevo producto</title>
</head>
<body>
	<h2>Insertar nuevó producto</h2>

	<s:form action="insertProducto">

		<!-- 		<input type="hidden" name="accion" value="insertar"> -->
		<table>
			<tr>
				<td><s:textfield name="productoBean.codArt" label="Codigo Art"></s:textfield></td>
			</tr>

			<tr>
				<td><s:textfield name="productoBean.seccion" label="Seccion"></s:textfield></td>
			</tr>

			<tr>
				<td><s:textfield name="productoBean.nombreArt" label="Nombre"></s:textfield></td>
			</tr>

			<tr>
				<td><s:textfield name="productoBean.precio" label="Precio"></s:textfield></td>
			</tr>

			<tr>
				<td><s:textfield name="productoBean.fecha" label="Fecha"></s:textfield></td>
			</tr>

			<tr>
				<td><s:textfield name="productoBean.importado"
						label="Importado"></s:textfield></td>
			</tr>

			<tr>
				<td><s:textfield name="productoBean.pais" label="Pais"></s:textfield></td>
			</tr>

			<tr>

				<td><s:submit value="Enviar"></s:submit></td>
				
				<td><s:reset value="Clear"></s:reset></td>
			</tr>

		</table>

	</s:form>
</body>
</html>