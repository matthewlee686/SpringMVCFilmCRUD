<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Add</title>
</head>
<body>

<h2><b>Add a Film:</b></h2>

	<form action="AddFilm.do" method="POST">
	
		<p><label for = "title">Title:</label>
		<input type="title" name="title" size="25"/></p>
		
		
		<p><label for = "releaseYear">Year Released:</label>
		<input type="text" name="releaseYear" size="7"/></p>
		
		<!-- Make Expandable Text Box -->
		<p><label for = "desc">Description:</label>
		<input type="text" name="desc" size="25"/></p>
		
		<!-- Some more input for Film Info -->
		
		<p><input type="submit" value = "Add Film"/></p>
	</form> 



</body>
</html>