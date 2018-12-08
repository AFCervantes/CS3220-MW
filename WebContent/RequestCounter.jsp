<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Counter JSP</title>
</head>
<body>

<%--
JSP Declaration
 --%>
<%! static int count = 0; %>


<%-- JSP Expression --%>
<h1>
	This page has been viewed <%= count %> time(s).
</h1>

<%-- JSP Scriptlet --%>
<% count++; %>

</body>
</html>