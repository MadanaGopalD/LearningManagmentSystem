<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="nav-bar.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
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
		<h1>Available Instructors</h1>
		<div align="right">
			<f:form action="search" modelAttribute="search" method="get">
				<label>Search</label>
				<f:input path="name" />
				<input type="submit" value="search">
			</f:form>
		</div>
		<br>
		<table class="table">
			<thead class="table-primary">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Experience</th>
					<th>Email</th>
					<th>Courses</th>
					<th>Delete</th>
				</tr>
			</thead>
			<c:forEach items="${instructors}" var="instructor">
				<tr>
					<td>${instructor.id}</td>
					<td>${instructor.name}</td>
					<td>${instructor.experience}</td>
					<td>${instructor.email}</td>
					<td>
					<table class="table">
							<thead class="table-warning">
								<tr>
									<th>Name</th>
									<th>Duration</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${instructor.courses}" var="courses">
									<tr>
										<td>${courses.name}</td>
										<td>${courses.duration} Days</td>
										<td><a href="/spring-lms-project/viewCourse?courseId=${courses.course_id}&pageNum=0">View</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</td>
					<td><a href="delete/${instructor.id}" class="btn btn-danger">Delete</a>
					</td>

				</tr>
			</c:forEach>
		</table>
		<a href="/spring-lms-project/user-reg" class="btn btn-success"
			style="float: right;">Add Instructor</a>
	</div>
</body>
</html>