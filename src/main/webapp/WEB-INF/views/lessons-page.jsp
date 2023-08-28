<%@page import="org.spring.lmsproject.entity.Lesson"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="nav-bar.jsp"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<body>
	<%
	Lesson lesson = (Lesson) request.getAttribute("lesson");
	int nextLessonId = lesson.getLessons_id() + 1;
	int previousLessionId = lesson.getLessons_id() - 1;
	pageContext.setAttribute("nextLessonId", nextLessonId);
	pageContext.setAttribute("previousLessionId", previousLessionId);
	%>
	<div class="container">
		<h1>${lesson.name}</h1>
		<hr>
		<h3>${lesson.lessonText}</h3>
	</div>
	<br>
	<br>
	<br>
	<div align="center">${lesson.link}</div>
	<c:if test="${nextLessonId <= lessonCount.lastLessonNumber}">
		<div align="right">
			<a href="/spring-lms-project/openLesson?id=${nextLessonId}"
				class="btn btn-info">Next Lesson</a>
		</div>
	</c:if>
	<c:if test="${previousLessionId >= lessonCount.firstLessonNumber}">
		<div align="left">
			<a href="/spring-lms-project/openLesson?id=${previousLessionId}"
				class="btn btn-info">Previous Lesson</a>
		</div>
	</c:if>
</body>
</html>