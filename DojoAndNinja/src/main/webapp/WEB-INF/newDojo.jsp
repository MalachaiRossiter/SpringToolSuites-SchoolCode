<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Creation</title>
</head>
<body>
	<h1>Create a New Dojo</h1>
	
	<form:form method="POST" action="/dojo/createDojo" modelAttribute="dojo">
		<form:label path="name">Name:</form:label>
		<form:errors path="name"/>
		<form:input path="name"/>
		<button>Create Dojo</button>
	</form:form>
</body>
</html>