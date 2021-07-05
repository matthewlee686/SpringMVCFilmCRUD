<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film ID Results</title>
</head>
<body>

<c:choose> 
	<c:when test="${!empty film || film != 0}">
	
		Film ID: ${film.id} 
		<br>
		Title: ${film.title} 
		<br> 
		Year Released: ${film.desc} 
		<br>
		Release Year: ${film.releaseYear} 
		<br>
		
		Starring: 
		<ul>
		<li> ${film.actors} </li>
		</ul>
		<br> 
		
	</c:when>
	<c:otherwise>
		No Films found with that ID
	</c:otherwise>
</c:choose>

	<!-- Link for Delete Film -->
<p><a href="deleteFilm.jsp">Delete the Film</a></p>
	
	<!-- Link for Edit Film Info-->
<p><a href="editFilm.jsp">Edit the Film</a></p>

<p><a href="/WEB-INF/home.jsp">Go Home</a></p>



</body>
</html>