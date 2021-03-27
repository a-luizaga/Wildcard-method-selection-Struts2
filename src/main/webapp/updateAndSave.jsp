<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar producto:</title>
</head>
<body>
	<h2>
		Actualizar producto:
		<s:property value="productoBean.codArt" />
	</h2>

	<s:form action="updateAndSave">

		<table>

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
		
		<s:hidden name="productoBean.codArt"></s:hidden>

	</s:form>
</body>
</html>