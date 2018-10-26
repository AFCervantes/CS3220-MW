<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Counter</title>
</head>
<body>

<%! static int count = 0; %>

<h1>
	This page has been viewed <%= count %> 
</h1>

<% count++; %>

</body>
</html>