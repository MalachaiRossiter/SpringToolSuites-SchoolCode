<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<bean id="myBeansValidator" class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean" />

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="KickBall/src/main/resources/static/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1><c:out value="${team.teamName}"/></h1>
	
	<p>This teams name is the <c:out value="${team.teamName}"/> </p>
	<p>Their skill level is: <c:out value="${team.skill}"/></p>
	<p>They will play their next game on: <c:out value="${team.day}"/></p>
	<c:set var="var1" value="${team.user.id }"/>
	<c:set var="var2" value="${user.id }"/>
		<c:if test="${var1 == var2}">
	<a href="/kickball/teams/edit/${team.id}" class="btn btn-outline-primary">edit</a>
	<a href="/kickball/teams/delete/${team.id}" class="btn btn-outline-primary">delete</a>
	</c:if>
	</div>
</body>
</html>