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
    <title>Save Travels</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="/">Go Back</a>
   	<form:form action="/expence/${expence.id}/edit" method="post" modelAttribute="expence">
   	   	<h1>Update <c:out value="${expence.itemName}"></c:out></h1>
   	   	<input type="hidden" name="_method" value="put">
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