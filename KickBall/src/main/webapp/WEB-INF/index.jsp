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
    <link rel="stylesheet" href="static/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
	   <h1 class="align-item-center">Sign-up Here! :)</h1>
			   <form:form action="/kickball/register" modelAttribute="newUser" method="POST" class="form">
   		<div class="form-group">
   			<form:label for="username" path="username" class="d-block">User Name:</form:label>
   			<form:errors path="username"/>
   			<form:input type="text" path="username" class="form-control"></form:input>
   		</div>
  		<div class="form-group">
   			<form:label for="email" path="email" class="d-block">Email:</form:label>
   			<form:errors path="email"/>
   			<form:input type="text" path="email" class="form-control"></form:input>
   		</div>
   		<div class="form-group">
   			<form:label for="password" path="password" class="d-block">Password:</form:label>
   			<form:errors path="password"/>
   			<form:input type="password" path="password" class="form-control"></form:input>
   		</div>
   		<div class="form-group">
   			<form:label for="confirmPassword" path="confirmPassword" class="d-block">Confirm Password:</form:label>
   			<form:errors path="confirmPassword" class="errors"/>
   			<form:input type="password" path="confirmPassword" class="form-control"></form:input>
   		</div>
   		<button class="btn btn-primary">SUBMIT</button>
   			</form:form>
	</div>
   
	<div class="container">
		   <form:form action="/kickball/login" modelAttribute="newLogin" class="form">
		   <h1>Login here</h1>
  		<div class="form-row">
   			<form:label for="email" path="email" class="d-block">Email:</form:label>
   			<form:errors path="email"/>
   			<form:input type="text" path="email" class="form-control"></form:input>
   		</div>
   		<div class="form-row">
   			<form:label for="password" path="password" class="d-block">Password:</form:label>
   			<form:errors path="password"/>
   			<form:input type="password" path="password" class="form-control"></form:input>
   		</div>
   		<button class="btn btn-primary">SUBMIT</button>
   </form:form>
	</div>
</body>
</html>