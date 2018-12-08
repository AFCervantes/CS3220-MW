<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- check if there is a session scope variable user --%>
<c:if test="${empty sessionScope.user}">
  <%-- redirect to Login.jsp --%>
  <c:redirect url="Login.jsp" />
</c:if>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Members Only</title>
</head>
<body>

<p style="text-align: right;">
	<a href="Logout.jsp">Logout</a>
</p>

<h1>Members Only Area</h1>
<h3>Welcome, ${user}</h3>


</body>
</html>