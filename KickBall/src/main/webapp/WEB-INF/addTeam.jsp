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
    <link rel="stylesheet" href="src/main/resources/static/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	
	<div class="container">
		<h1>Add a new Team!</h1>
		<a href="/kickball/dashboard" class="btn btn-outline-secondary">Back to Dashboard</a>
		<form:form action="/kickball/createTeam" modelAttribute="team" class="form" method="post">
		<div class="form-group">
   			<form:label for="teamName" path="teamName" class="d-block">Team Name</form:label>
   			<form:errors path="teamName"/>
   			<form:input type="text" path="teamName" class="form-control"></form:input>
   		</div>
  		<div class="form-group">
   			<form:label for="skill" path="skill" class="d-block">Skill Level (1-5):</form:label>
   			<form:errors path="skill"/>
   			<form:input type="text" path="skill" value="1" class="form-control"></form:input>
   		</div>
   		<div class="form-group">
   			<form:label for="day" path="day" class="d-block">Game Day:</form:label>
   			<form:errors path="day"/>
   			<form:input type="text" path="day" class="form-control"></form:input>
   		</div>
  		<div class="form-group">
			<form:errors path="user" class="error"/>
			<form:input type="hidden" path="user" value="${user.id}" class="form-control"/>
		</div>
   		<button class="btn btn-primary">SUBMIT</button>
		</form:form>
	</div>
</body>
</html>