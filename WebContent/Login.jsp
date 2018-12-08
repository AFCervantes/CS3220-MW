<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty param.login}">
  <c:if test="${param.username == 'albert' and param['password'] == 'abcd'}">
    <c:set var="user" value="${param.username}" scope="session" />
    <c:redirect url="Members.jsp" />
  </c:if>
</c:if>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Login</title>
</head>
<body>

<c:if test="${not empty param.login}">
	<p style="color: red;">Invalid Username and/or Password</p>
</c:if>

<form action="Login.jsp" method="post">
	Username: <input type="text" name="username" /> <br />
	Password: <input type="text" name="password" /> <br />
	<input type="submit" name="login" value="Login" />
</form>

</body>
</html>