

<%@page import="com.pojo.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body>

	<%
		List<Question> qstns = (List<Question>) request.getAttribute("matchingquestions");
		Question qstn = qstns.get(qstns.size() - 1);
	%>

	<nav class="navbar navbar-dark bg-dark">
		<span class="navbar-brand mb-0 h1"><a href="index.jsp"
			style="text-decoration: none; color: white">POLLS 'N' POLLS</a></span>
		<h5 align="right" class="navbar-brand mb-0 h1">Current User:
			${user}</h5>
		<core:if test="${empty user}">
			<span style="align-self: right; text-decoration: none;"><a
				href="login.jsp" class="navbar-brand mb-0 h1">Login</a></span>
		</core:if>

		<core:if test="${not empty user}">
			<span style="align-self: right; text-decoration: none;"><a
				href="logout" class="navbar-brand mb-0 h1">Logout</a></span>
		</core:if>




	</nav>
	<div class="container-fluid bg-light" style="min-height: 100vh">
		<div class="container">
			<div align="center">
				<table class="table-borderless">

					<th class="table-active" style="text-align: center;">Questions</th>

					<core:forEach items="${matchingquestions}" var="q">

						<tr>
							<td><a href="displayone?questionId=${q.questionId}">${q.question}</a></td>

						</tr>


					</core:forEach>
				</table>



			</div>
			<div align="center">

				<h5>Similar Questions Exist..Do you still want to add new??</h5>

				<a
					href="confirmadd?question=<%=qstn.getQuestion()%>&keywords=<%=qstn.getKeywords()%>"><input
					type="submit" class="btn btn-primary" value="Yes"></a> <a
					href="addquestion.jsp"><input type="submit"
					class="btn btn-secondary" value="No"></a>

			</div>



		</div>
	</div>



</body>
</html>