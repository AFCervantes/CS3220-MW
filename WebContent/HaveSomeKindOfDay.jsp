<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Day JSP</title>
</head>
<body>

<% if (Math.random() > 0.5){ %>
<h1>Have a great day!</h1>
<% } else { %>
<h1>Have a lousy day!</h1>
<% } %>

</body>
</html>