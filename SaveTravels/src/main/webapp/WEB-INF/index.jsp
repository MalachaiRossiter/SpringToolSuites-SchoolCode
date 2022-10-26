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
    <title>Save Travels</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   	<h1>Welcome to Save Travels</h1>
   	<table class="table table-striped">
   		<thead>
  		   	<tr>
   				<td>Item Name</td>
   				<td>Vendor</td>
   				<td>Item Price</td>
   				<td>Options</td>
   			</tr>
   		</thead>
   		<tbody>
   		<c:forEach var="expence" items="${expences}">
   			<tr>
   				<td><c:out value="${expence.getItemName()}" /></td>
   				<td><c:out value="${expence.getVendor()}" /></td>
   				<td><c:out value="${expence.getCost()}" /></td>
   				<td><a href="/expence/${expence.id}/edit"><button>Edit</button></a> <a href="/expence/${expence.id}/delete"><button>Delete</button></a></td>
   			</tr>
   		</c:forEach>
   		</tbody>
   	</table>
   	
   	<form:form action="/expence/create" method="post" modelAttribute="expence">
   		<div>
   			<form:label path="itemName">Item Name</form:label>
   			<form:input path="itemName"/>
   			<form:errors path="itemName"/>
   		</div>
   		<div>
   			<form:label path="vendor">Vendor</form:label>
   			<form:input path="vendor"/>
   			<form:errors path="vendor"/>
   		</div>
   		<div>
   			<form:label path="cost">Price</form:label>
   			<form:input path="cost"/>
   			<form:errors path="cost"/>
   		</div>
   		<button>Submit</button>
   	</form:form>
</body>
</html>