<%@page import="com.pojo.Question"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
</head>
<body>

         <% Question question = (Question)request.getAttribute("question"); %>
          
    	<nav class="navbar navbar-dark bg-dark">
		<span class="navbar-brand mb-0 h1"><a href="index.jsp" style="text-decoration: none ; color: white">POLLS 'N' POLLS</a></span>
	</nav>
	<div class="container-fluid bg-light" style="min-height: 100vh">
		<div class="container">
			<div align="center">
				<table class="table-borderless">
				   <th class="table-active" style="text-align: center;">Question</th>
                     <tr>
						<td>${question.question}</td>
				    </tr>
				
				   
                     <tr>
						<td align="center"><a href="increment?questionId=${question.questionId }&option=yes"><button type="button"  class="btn btn-success" style="margin-top: 50px; width:50%;">Yes</button></a></td>
				    </tr>
				    <tr>
						<td align="center"><a href="increment?questionId=${question.questionId }&option=no"><button type="button" class="btn btn-danger" style="margin-top: 15px; width:50%;">No</button></a></td>
				    </tr>
				    <tr>
						<td  align="center"><a href="increment?questionId=${question.questionId }&option=notSure"><button type="button" class="btn btn-warning"style="margin-top: 15px ; width:50%;">Not Sure</button></a></td>
				    </tr>
				</table>
             </div>

		</div>
	</div>
   

</body>
</html>