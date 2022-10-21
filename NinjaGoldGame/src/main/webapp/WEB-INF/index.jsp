<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gold</title>
</head>
<body>
	<h1>Your Gold <c:out value="${total}"></c:out></h1>
	<div class="container">
		<h2>Farm</h2>
		<p>(earns 10-20 gold)</p>
		<form action="/process" method="post">
			<input type="submit" name="farm" value="Find Gold" />
		</form>
	</div>
	
	<div class="container">
		<h2>Cave</h2>
		<p>(earns 0-30 gold)</p>
		<form action="/process" method="post">
			<input type="submit" name="cave" value="Find Gold" />
		</form>
	</div>
	
	<div class="container">
		<h2>House</h2>
		<p>(takes 10-20 gold)</p>
		<form action="/process" method="post">
			<input type="submit" name="house" value="Find Gold" />
		</form>
	</div>
	
	<div class="container">
		<h2>Quest</h2>
		<p>(takes/earns 0-50 gold)</p>
		<form action="/process" method="post">
			<input type="submit" name="quest" value="Find Gold" />
		</form>
	</div>
</body>
</html>