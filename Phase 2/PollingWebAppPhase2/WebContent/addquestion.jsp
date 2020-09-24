<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a Poll</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<span class="navbar-brand mb-0 h1"><a href="index.jsp"
			style="text-decoration: none; color: white">POLLS 'N' POLLS</a></span>
	</nav>
	<div class="container-fluid bg-light" style="min-height: 100vh">
		<div class="container">

			<div class="jumbotron mt-4" style="margin-top: 100px">
				<form action="ask">
					<h2 align="center">Create Your Own Poll</h2>

					<div class="input-group input-group-lg">

						<input type="text" name="question"
							placeholder="Type the Question here (MAX 250 CHARACTERS)"
							class="form-control" aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-lg">


					</div>
					<div class="input-group input-group-lg"
						style="margin-top: 15px; margin-bottom: 50px;">

						<div class="input-group input-group-lg">

							<input type="text" name="keywords"
								placeholder="Type',' separated keywords which matches your Question"
								class="form-control" aria-label="Sizing example input"
								aria-describedby="inputGroup-sizing-lg">

						</div>


					</div>

					<div align="center">
						<input type="submit" class="btn btn-primary btn-lg"
							value="Create Poll">
						</button>
					</div>
				</form>



			</div>

			<core:if test="${not empty message}">

				<h5 align="center">Poll Created Sucessfully!!</h5>


			</core:if>


		</div>
	</div>





</body>
</html>