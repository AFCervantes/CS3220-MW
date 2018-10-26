<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean class="models.BGBean" id="bg" scope="application" />

<%-- 
	<jsp:setProperty name="bg" property="g" value="128" />
	<jsp:setProperty name="bg" property="b" />
--%>

<jsp:setProperty name="bg" property="*" />



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>BG Color</title>
	<style type="text/css">
		body {
			background-color: rgb(
									<jsp:getProperty property="r" name="bg"/>, 
									<jsp:getProperty property="g" name="bg"/>, 
									<jsp:getProperty property="b" name="bg"/>
								 )
			}
	</style>

</head>
<body>

<h1>
	The background color is:
	
	
	rgb(
		<jsp:getProperty property="r" name="bg"/>, 
		<jsp:getProperty property="g" name="bg"/>, 
		<jsp:getProperty property="b" name="bg"/>)
	
</h1>

</body>
</html>