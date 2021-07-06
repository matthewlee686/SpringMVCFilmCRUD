<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Film ID Results</title>
</head>
<body>

	<c:choose>
		<c:when test="${ empty film}">
	
		<p>No Films found with that ID</p>

		</c:when>
		<c:otherwise>
		<h3>Film Info:</h3>
		Film ID: ${film.id} 
		<br>
		Title: ${film.title} 
		<br> 
		Description: ${film.desc} 
		<br>
		Release Year: ${film.releaseYear} 
		<br>
		<br>
		<h3>Starring:</h3>
			<c:forEach var="actor" items="${film.actors}">
				<ul>
					<li><b>Actor ID:</b> ${actor.id}
					<li><b>First Name:</b> ${actor.firstName}</li>
					<li><b>Last Name:</b> ${actor.lastName}</li>
				</ul>
			</c:forEach>
			<br>

		</c:otherwise>
	</c:choose>

	<!-- Link for Delete Film -->
	<p>
		<a href="deleteFilm.jsp">Delete the Film</a>
	</p>

	<!-- Link for Edit Film Info-->
	<p><a href="updateFilmForm.html">Edit the Film</a></p>

	<p>
		<a href="home.jsp">Go Home</a>
	</p>



</body>
</html>