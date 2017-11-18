<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editorial</title>
</head>
<body>
	<table border= "1">
		<tr>
			
			<th>
			
				<form action="EditorialController1">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Nombre</th>
			 <th>Email</th>
			 <th>Pais</th>
			 <th>Tipo</th>
			
		</tr>
		<c:forEach var="editorial" items="${editoriales}">
		
		<tr>
			<td>
				<form action= "EditorialController1">
					<input type = "hidden" name = "id" value= "${editorial.id}"/>
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete"/>
				</form>
			</td>
			<td> ${editorial.id}</td>
			<td> ${editorial.nombre}</td>
			<td> ${editorial.email}</td>
			<td> ${editorial.pais}</td>
			<td> ${editorial.tipo}</td>
		</tr>
		
		</c:forEach>
		
	
	</table>
	<form action="EditorialReport">
				
					<input type = "submit" name = "btn_reporte" value = "Reporte"/>
				</form>

</body>
</html>