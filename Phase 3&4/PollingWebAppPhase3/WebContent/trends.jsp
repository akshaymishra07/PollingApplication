<%@page import="com.pojo.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body>
           
            

	<nav class="navbar navbar-dark bg-dark">
		<span class="navbar-brand mb-0 h1"><a href="index.jsp" style="text-decoration: none ; color: white">POLLS 'N' POLLS</a></span>
	    
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
				<table class="table-borderless" style="width: 100%">

					<th class="table-active" style="text-align: center;">TOP THREE TRENDING QUESTIONS</th>

                    <core:forEach items="${topThree}" var="q">

					<tr>
						<td style="text-align: center;"><a href="displayone?questionId=${q.questionId}">${q.question}</a></td>
						
					</tr>


				</core:forEach>
				</table>



			</div>
			<div align="center">
				<table class="table-borderless" style="width: 100%">

					<th class="table-active" style="text-align: center;">TOP THREE TRENDING QUESTIONS</th>

                    <core:forEach items="${trendingKeywords}" var="q">

					<tr>
						<td style="text-align: center;">${q}</td>
						
					</tr>


				</core:forEach>
				</table>



			</div>

		</div>
	</div>

</body>
</html>