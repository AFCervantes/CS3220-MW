<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Adder</title>
</head>
<body>

<%

// Defined here for scope
int num1;
int num2;

try{
	num1 = Integer.parseInt( request.getParameter("num1"));
	num2 = Integer.parseInt( request.getParameter("num2"));
	
}catch(Exception e){
	response.sendRedirect("JspAdder.html");
	return;
}

%>

The sum of 
	<%= num1 %> 
	+ 
	<%= num2 %> 
	= 
	<%= num1 + num2 %>

</body>
</html>