<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Send an Omikuji</h1>
	<div class="container">
		<form action="/process" method="post">
			<label for="number">pick a number between 0 and 100000</label>
			<input type="number" name="number"/>
			<label for="city">enter the name of a city in your brain</label>
			<input type="text" name="city"/>
			<label for="person">enter the name of a person in the mind</label>
			<input type="text" name="person"/>
			<label for="hobby">enter the name of a hobby in your toes</label>
			<input type="text" name="hobby"/>
			<label for="thing">enter a thing</label>
			<input type="text" name="thing"/>
			<label for="message">write a message for someone</label>
			<textarea name="message" id="" cols="30" rows="10" name="message"></textarea>
			<p>send to a friend you hate :D</p>
			<input type="submit" value="Send" />
		</form>
	</div>
</body>
</html>