<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Film Results</title>
</head>
<body>


<h2>Film Add Results:</h2>

	<c:choose>
		<c:when test="${empty film}">
			<p>Film could not be added</p>
		</c:when>
		<c:otherwise>
			<p>--Film has been added--</p>
			<p>Results for New Film Added:</p>
				<ul>
					<li>${film.id}</li>
					<li>${film.title}</li>
					<li>${film.releaseYear}</li>
				</ul>
		</c:otherwise>
	</c:choose>

</body>
</html>