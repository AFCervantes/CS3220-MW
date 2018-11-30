<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%-- set data source --%>
<sql:setDataSource
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://cs3.calstatela.edu/cs3220stu120"
	user="cs3220stu120"
	password="" />

<c:if test="${not empty param.add}">
  
  <sql:update>
  
    insert into guestbook (name, message) values (?, ?)
    
    <sql:param value="${param.name}" />
    <sql:param value="${param.message}" />
    
  </sql:update>
  
  <c:redirect url="GuestBook.jsp" />
</c:if>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AddComment.jsp" method="post">
		Name: <input type="text" name="name" /> <br />
		Message: <input type="text" name="message" /> <br />
		<input type="submit" name="add" value="Add" />
	</form>
</body>
</html>