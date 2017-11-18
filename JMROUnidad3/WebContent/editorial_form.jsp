<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editorial Form</title>
</head>
<body>
	<form action="EditorialController1">
		<label>Nombre:</label><br>
		<input type = "text" name= "nombre" value = "${editorial.nombre}" /><br>
		
		<label>Email:</label><br>
		<input type = "text" name= "email" value = "${editorial.email}" /><br>
		
		<label>Pais:</label><br>
		<input type = "text" name= "pais" value = "${editorial.pais}" /><br>
		
		<label>Tipo:</label><br>
		<input type = "text" name= "tipo" value = "${editorial.tipo}" /><br>
		
		
		<input type = "submit" name = "btn_save" id="btn_save" value = "Save"/>
	</form>
</body>
</html>