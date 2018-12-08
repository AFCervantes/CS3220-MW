<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Comment</title>
</head>
<body>

<form action="AddComment" method="post">

	<c:if test="${not empty nameError }">
		<p style="color: red;">${nameError}</p>
	</c:if>
	
	Name: <input type="text" name="name" value="${param.name}">	<br>
	
	<c:if test="${not empty messageError }">
		<p style="color: red;">${messageError}</p>
	</c:if>
	
	Message: <br>
	<textarea name="message">${param.message}</textarea> <br>
	<input type="submit" value="Add Comment">	
</form>

</body>
</html>