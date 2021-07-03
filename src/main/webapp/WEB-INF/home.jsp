<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Land!</title>
</head>
<body>

<h2>Project Spring MVC CRUD</h2>
<hr>
<br>

	<form action="GetFilmByID.do" method="GET">
		Enter Film ID Here:
		<input type="text" name="id" size="4"/> 
		<input type="submit" value="Get Film Info" />
	</form> 
	<br>
	<form action="GetFilmBySearch.do" method="GET">
		Enter Film Query Here:
		<input type="text" name="search" size="25"/> 
		<input type="submit" value="Get Film Info" />
	</form> 
	
	<!-- Add Link for Delete Film -->
<p><a href="deleteFilm.html">Delete a Film</a></p>
	
	<!-- Add Link for Edit Film Info-->
<p><a href="editFilm.html">Edit a Film</a></p>

</body>
</html>