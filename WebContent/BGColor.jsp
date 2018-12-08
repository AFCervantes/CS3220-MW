<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean class="models.BGBean" id="bg" scope="application"/>

<%--
<jsp:setProperty name="bg" property="g" value="150" />
<jsp:setProperty name="bg" property="b" />
 --%>
 
 <jsp:setProperty name="bg" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Background Color</title>

<style type="text/css">
body{
	background-color: rgb(<jsp:getProperty name="bg" property="r" />, 
						  <jsp:getProperty name="bg" property="g" />, 
						  <jsp:getProperty name="bg" property="b" />);
	
}
</style>

</head>
<body>



<h1>
The background color is: rgb(
							<jsp:getProperty name="bg" property="r" />, 
							<jsp:getProperty name="bg" property="g" />, 
							<jsp:getProperty name="bg" property="b" />)

</h1>

</body>
</html>