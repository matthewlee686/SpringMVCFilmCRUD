<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Film Confirmation</title>
</head>
<body>

<h2>Film Update Results:</h2>
	<c:choose>
		<c:when test="${! empty film}">
			<p>Film ${film.id} ${film.title} has been successfully updated</p>
		</c:when>
		<c:otherwise>
			<p>Film could not be updated</p>
		</c:otherwise>
	</c:choose>

</body>
</html>