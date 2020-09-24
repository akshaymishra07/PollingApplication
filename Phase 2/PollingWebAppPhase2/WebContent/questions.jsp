
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
           <% 
               List<Question> str = (List<Question>)request.getAttribute("questions");
               
               
           %>
            

	<nav class="navbar navbar-dark bg-dark">
		<span class="navbar-brand mb-0 h1"><a href="index.jsp" style="text-decoration: none ; color: white">POLLS 'N' POLLS</a></span>
	</nav>
	<div class="container-fluid bg-light" style="min-height: 100vh">
		<div class="container">
			<div align="center">
				<table class="table-borderless">

					<th class="table-active" style="text-align: center;">Questions</th>

                    <core:forEach items="${questions}" var="q">

					<tr>
						<td><a href="displayone?questionId=${q.questionId}">${q.question}</a></td>
						
					</tr>


				</core:forEach>
				</table>



			</div>

		</div>
	</div>

</body>
</html>