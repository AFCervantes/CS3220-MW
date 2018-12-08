<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:useBean id="gb" class="models.GuestBookBean" scope="application" />  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Guestbook</title>
</head>
<body>

<c:if test="${ fn:length(gb.entries) == 0 }">
	<h3>No entries have been added. Please sign our guestbook.</h3>
</c:if>


<c:if test="${ fn:length(gb.entries) > 0 }">

	<table border="1">
		<tr><th>Index</th><th>Name</th><th>Message</th><th>Date</th></tr>
		<c:forEach items="${gb.entries}" var="entry" varStatus="status">
			<tr>
			  <td>${status.index+1}</td>
			  <td>
			  	<c:out value="${entry.name}" />
			  </td>
			  <td>
			  	<c:out value="${entry.message}" />
			  </td>
			  <td>
			  	<fmt:formatDate value="${entry.date}" pattern="yyyy-MM-dd" />
			  </td>
			</tr>
		</c:forEach>
	</table>

</c:if>

<a href="AddComment.jsp">Sign Guestbook!</a>

</body>
</html>





