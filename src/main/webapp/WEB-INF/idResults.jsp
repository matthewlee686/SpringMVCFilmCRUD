<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Film ID Results</title>
</head>
<body>

	<c:choose>
		<c:when test="${ empty film}">
	
		<p>No Films found with that ID</p>

		</c:when>
		<c:otherwise>
	Film ID: ${film.id} 
		<br>
		Title: ${film.title} 
		<br> 
		Description: ${film.desc} 
		<br>
		Release Year: ${film.releaseYear} 
		<br>
		
		Starring: 
		<ul>
				<li>${film.actors}</li>
			</ul>
			<br>

		</c:otherwise>
	</c:choose>

	<!-- Link for Delete Film -->
	<p>
		<a href="deleteFilm.jsp">Delete the Film</a>
	</p>

	<!-- Link for Edit Film Info-->
	<p>
		<a href="editFilm.jsp">Edit the Film</a>
	</p>

	<p>
		<a href="home.jsp">Go Home</a>
	</p>



</body>
</html>