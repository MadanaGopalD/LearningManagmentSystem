<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ include file="nav-bar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Add Course</h1>
		<hr>
	</div>
	<f:form action="addCourse" method="POST" modelAttribute="course">
		<div align="center">
			<p>
				<label>Course Name</label>
				<f:input path="name" />
			</p>
			<p>
				<label>Course Duration</label>
				<f:input path="duration" />
			</p>
			<p>
				<label>Select Instructor</label>
				<f:select path="instructor.id">
					<c:forEach items="${instructors}" var="instructor">
						<f:option value="${instructor.id}">${instructor.name}</f:option>
					</c:forEach>
				</f:select>
			</p>
			<p>
				<input type="submit" value="Add">
			</p>
		</div>
	</f:form>
</body>
</html>