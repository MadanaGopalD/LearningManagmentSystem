<%@page import="org.spring.lmsproject.entity.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tag" %>
<%@ include file="nav-bar.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
Course course = (Course) request.getSession().getAttribute("course");
int minSize = course.getLessons().size();
pageContext.setAttribute("minSize", minSize);
%>
<body>
<tag:url value="/viewCourse?courseId=${course.course_id}" var="viewCourseUrl"></tag:url>
	<p>
	<div>
		<h1>${course.name} &emsp;<a href="/spring-lms-project/addLesson"
		class="btn btn-success">AddLessons</a></h1>
	</div>	
	<hr>
	
	<h2>Lessons</h2>
	<c:choose>
		<c:when test="${minSize>0}">
			<c:forEach items="${pagedListHolder.pageList}" var="lessons">
				<a href="/spring-lms-project/openLesson?id=${lessons.lessons_id}">${lessons.name}</a>
				<a href="/spring-lms-project/addLesson?lessonId=${lessons.lessons_id}">Edit</a>
				<br>
				<br>
			</c:forEach>
			<c:choose>
				<c:when test="${pagedListHolder.firstPage}">Prev</c:when>
				<c:otherwise>
					<a
						href="${viewCourseUrl}&pageNum=prev">Prev</a>
				</c:otherwise>
			</c:choose>
			<c:forEach begin="0" end="${pagedListHolder.pageCount-1}"
				var="number">
				<c:choose>
					<c:when test="${number==pagedListHolder.page}">${number}</c:when>
					<c:otherwise>
						<a
							href="${viewCourseUrl}&pageNum=${number}">${number}</a>
					</c:otherwise>
				</c:choose>

			</c:forEach>
			<c:choose>
				<c:when test="${pagedListHolder.lastPage}">Next</c:when>
				<c:otherwise>
					<a
						href="${viewCourseUrl}&pageNum=next">Next</a>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
No Lessons Found ):
</c:otherwise>
	</c:choose>
</body>
</html>