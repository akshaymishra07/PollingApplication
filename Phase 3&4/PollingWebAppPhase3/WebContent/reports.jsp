
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<style type="text/css">
th, td {
	width: 150px;
	text-align: center;
	border: 1px solid black;
	padding: 5px
}
</style>
</head>
<body>



	<nav class="navbar navbar-dark bg-dark">
		<span class="navbar-brand mb-0 h1"><a href="index.jsp" style="text-decoration: none; color: white">POLLS 'N' POLLS</a></span>
	    
	     <core:if test="${empty user}">
			<span style="align-self: right; text-decoration: none;"><a
				href="login.jsp" class="navbar-brand mb-0 h1">Login</a></span>
		</core:if>
		<core:if test="${not empty user}">
		    <h5 align="right" class="navbar-brand mb-0 h1">Current User:  ${user}</h5>
			<span style="align-self: right; text-decoration: none;"><a
				href="logout" class="navbar-brand mb-0 h1">Logout</a></span>
		</core:if>
	 
	</nav>
	<div class="container-fluid bg-light" style="min-height: 100vh">
		<div class="container">
			<div align="center">
				<table class="table-bordered">

					<th class="thead-dark">QUESTION</th>
					<th style="color: #fff; background-color: #28a745;">YES</th>
					<th style="background-color: #dc3545; color: #fff;">NO</th>
					<th style="color: #212529; background-color: #ffc107;">NOT
						SURE</th>

					<core:forEach items="${questions}" var="q">

						<tr>
							<td>${q.question}</td>
							<td><fmt:formatNumber maxFractionDigits="2"
									value="${((q.yes)/(q.yes+q.no+q.notSure))*100}"></fmt:formatNumber>%</td>
							<td><fmt:formatNumber maxFractionDigits="2"
									value="${((q.no)/(q.yes+q.no+q.notSure))*100}"></fmt:formatNumber>%</td>
							<td><fmt:formatNumber maxFractionDigits="2"
									value="${((q.notSure)/(q.yes+q.no+q.notSure))*100}"></fmt:formatNumber>%</td>
						</tr>


					</core:forEach>
				</table>



			</div>

		</div>
	</div>

</body>
</html>