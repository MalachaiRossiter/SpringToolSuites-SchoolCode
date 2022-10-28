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
<title>Create New Ninja</title>
</head>
<body>
	<h1>Create a ninja</h1>
	
	<form:form method="POST" action="/ninja/createNinja" modelAttribute="ninja">
	
		<form:label path="dojo">Select Dojo</form:label>
		<form:errors path="dojo"/>
		<form:select path="dojo">
		<c:forEach items="${allDojos}" var="dojo">
		<option value="${dojo.id}">${dojo.name}</option>
		</c:forEach>
		</form:select>
		
		<form:label path="firstName">First Name:</form:label>
		<form:errors path="firstName"/>
		<form:input path="firstName"/>
		
		<form:label path="lastName">Last Name:</form:label>
		<form:errors path="lastName"/>
		<form:input path="lastName"/>
		
		<form:label path="age">Age:</form:label>
		<form:errors path="age"/>
		<form:input path="age"/>
		<button>Create Ninja</button>
	</form:form>
</body>
</html>