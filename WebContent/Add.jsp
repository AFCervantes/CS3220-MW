<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Adder</title>
</head>
<body>

<h3>

		<%
		
		int num1 = 0, num2 = 0;
		
		try{
			String str1 = request.getParameter("num1");
			String str2 = request.getParameter("num2");

			num1 = Integer.parseInt( str1 );
			num2 = Integer.parseInt( str2 );
			
		}catch(Exception e){
			
			response.sendRedirect("JspAdder.html");
			return;
			
		}
		
		%>

		The sum of 
		
		<%= num1 %>
		
		and 
		
		<%= num2 %>
		
		is: 
		
		<%= num1 + num2 %>
</h3>

</body>
</html>