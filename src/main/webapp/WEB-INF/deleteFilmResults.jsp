<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Results</title>
</head>
<body>
<h2>Deletion Results:</h2>
	<c:choose>
		<c:when test="${ empty film}">
			<p>Film ${film.id } ${film.title} has been successfully deleted</p>
		</c:when>
		<c:otherwise>
			<p>Film could not be deleted</p>
		</c:otherwise>
	</c:choose>

	<a href="home.jsp">Go Home</a><br/>
</body>
</html>