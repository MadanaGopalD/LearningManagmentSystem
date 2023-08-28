<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary ">
		<div class="container-fluid">
			<a class="navbar-brand" href="/spring-lms-project/home">LMS</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/spring-lms-project/home">Instructors</a></li>
					<li class="nav-item"><a class="nav-link" href="/spring-lms-project/user-reg">Add Instructors</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="/spring-lms-project/addCourse">Add Course</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<script type="module">
  import { Toast } from 'bootstrap.esm.min.js'

  Array.from(document.querySelectorAll('.toast'))
    .forEach(toastNode => new Toast(toastNode))
</script>
</body>
</html>