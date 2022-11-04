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
    <meta charset="UTF-8">
    <title>Book Club - Login</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <h1>Welcome to the login screen :)</h1>
   <form:form action="/register" modelAttribute="newUser" class="form">
   		<div class="form-row">
   			<form:label for="username" path="username">User Name:</form:label>
   			<form:errors path="username"/>
   			<form:input type="text" path="username"></form:input>
   		</div>
  		<div class="form-row">
   			<form:label for="email" path="email">Email:</form:label>
   			<form:errors path="email"/>
   			<form:input type="text" path="email"></form:input>
   		</div>
   		<div class="form-row">
   			<form:label for="password" path="password">Password:</form:label>
   			<form:errors path="password"/>
   			<form:input type="password" path="password"></form:input>
   		</div>
   		<div class="form-row">
   			<form:label for="confirmPassword" path="confirmPassword">Confirm Password:</form:label>
   			<form:errors path="confirmPassword"/>
   			<form:input type="password" path="confirmPassword"></form:input>
   		</div>
   		<button>SUBMIT</button>
   </form:form>
</body>
</html>