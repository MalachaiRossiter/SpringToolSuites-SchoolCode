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
   		<h1>Welcome <c:out value="${user.username}"></c:out></h1>
   <a href="/kickball/logout" class="btn btn-outline-secondary">Logout</a>
   
   <table class="table table-striped">
   		<tr>
   			<th>Team Name</th>
   			<th>Skill Level</th>
   			<th>Game Day</th>
   		</tr>
  		<c:forEach var="team" items="${teams}">
   			<tr>
   				<td><a href="/kickball/teams/${team.id}"><c:out value="${team.teamName}"/></a></td>
   				<td><c:out value="${team.skill}"/></td>
   				<td><c:out value="${team.day}"/></td>
   			</tr>
   		</c:forEach>
   </table>
   <a href="/kickball/createTeam" class="btn btn-outline-primary">Create New Team</a>
   </div>
</body>
</html>