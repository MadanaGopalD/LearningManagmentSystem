<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="nav-bar.jsp"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Add Lessons to the course ${course.name}</h1>
		<hr>
		<f:form action="addLesson" method="POST" modelAttribute="lesson">
			<div align="center">
				<p>
					<f:hidden path="lessons_id" />
				</p>
				<p>
					<label>Lesson Name</label>
					<f:input path="name" />
				</p>
				<p>
					<label>Lesson Text</label>
					<f:textarea path="lessonText" />
				</p>
				<p>
					<label>Lesson Url</label>
					<f:textarea path="link" />
				</p>
				<p>
					<input type="submit" value="Add" class="btn btn-success">
				</p>
			</div>
		</f:form>
	</div>
</body>
</html>