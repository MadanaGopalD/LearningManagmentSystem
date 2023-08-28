<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ include file="nav-bar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h1>Add Instructor</h1>
	<hr>
	<f:form action="save-instructor" method="post" modelAttribute="instructor">
		<div align="center">
			<p>
				<label>Name</label>
				<f:input path="name" />
			</p>
			<p>
				<label>Experience</label>
				<f:input path="experience" />
			</p>
			<p>
				<label>Email</label>
				<f:input path="email" />
			</p>
			<p>
			<input type="submit" value="Register">
			</p>
		</div>
	</f:form>
</div>
</body>
</html>