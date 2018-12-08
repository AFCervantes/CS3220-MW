<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gb" class="models.GuestBookBean" scope="application" />

<c:if test="${not empty param.add}">

  <%-- invoke setAddEntry() to create an empty entry --%>
  <jsp:setProperty name="gb" property="addEntry" value="dummy" />

  <%-- set name & message into the new entry --%>
  <c:set target="${gb.lastEntry}" property="name" value="${param.name}" />
  <c:set target="${gb.lastEntry}" property="message" value="${param.message}" />
  
  <c:redirect url="GuestBook.jsp" />
</c:if>   

 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Add Comment</title>
</head>
<body>
	<form action="AddComment.jsp" method="post">
		Name: <input type="text" name="name" /> <br />
		Message: <input type="text" name="message" /> <br />
		<input type="submit" name="add" value="Add" />
	</form>
</body>
</html>