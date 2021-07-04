<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--Show Film Info

Film's To String 
Actors should show with this

-->

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


	<!-- Link for Delete Film -->
<p><a href="deleteFilm.html">Delete the Film</a></p>
	
	<!-- Link for Edit Film Info-->
<p><a href="editFilm.html">Edit the Film</a></p>



</body>
</html>