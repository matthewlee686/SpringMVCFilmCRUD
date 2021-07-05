<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete a Film</title>
</head>
<body>
	<h2>Delete the film with the film ID</h2>
	<form action="deleteFilm.do" method="GET">
		Enter Film ID: <input type="text" name="delete" size="4" /> <input
			type="submit" value="Delete Film" />
	</form>
	<h2>Delete the film with a keyword</h2>
	<form action="deleteFilm.do" method="GET">
		Enter Film ID: <input type="text" name="delete" size="15" /> <input
			type="submit" value="Delete Film" />
	</form>
	
</body>
</html>