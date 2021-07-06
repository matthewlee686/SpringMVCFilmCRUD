<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Query Results</title>
</head>
<body>

<h2>Search Results: </h2>

	<c:choose>
		<c:when test="${!empty films}">
			<c:forEach var="film" items="${films}">
				<ul>
					<li><b>Film ID:</b> ${film.id}
					<li><b>Title:</b> ${film.title}</li>
					<li><b>Release Year:</b> ${film.releaseYear}</li>
				</ul>
			</c:forEach>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
	<br>
	<p>${films.size()} Results Found</p>
	
	<!-- Link for Delete Film -->
<p><a href="deleteFilm.jsp">Delete a Film</a></p>
	
	<!-- Link for Edit Film Info-->
<p><a href="editFilm.jsp">Edit a Film</a></p>
	
	<!--  Go to Home Page -->
<p><a href="home.jsp">Go Home</a></p>


</body>
</html>