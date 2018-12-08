<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="cs3220" uri="http://cs3.calstatela.edu/cs3220stu120/examples" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Taglib Test</title>
</head>
<body>

<p>This is the result of the AddTag:
	<cs3220:add op1="${param.num1}" op2="${param.num2}" />
</p>

<p>
	This is the requestInfo tag:

	<cs3220:requestInfo type="method" />, 
	<cs3220:requestInfo type="client" />.<br />
	<cs3220:requestInfo type="uri" /> <br />
	<cs3220:requestInfo type="isGzipSupported" />
</p>

<p>
	This is the cap tag:
	<cs3220:cap> <cs3220:requestInfo type="uri" /> </cs3220:cap>.
</p>


<p>
	This is the tag file:
	<cs3220:greeting name="Albert">Hello</cs3220:greeting>
</p>

<p>
	This is the EL function:
	${cs3220:leetTalk('fear my mad programming skills')}.
</p>

</body>
</html>
