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

<c:if test="${! empty param.setPrice}">
    
    <sql:update var="r">
        update items set price = ? where name = ?
        <sql:param value="${param.price}"/>
        <sql:param value="${param.name}"/>
    </sql:update>

</c:if>


<%-- query --%>
<sql:query var="items">
	SELECT * 
	FROM items
	<%-- WHERE price < ?
		AND quantity > ?
		
	<sql:param value="${param.price}" />
	<sql:param value="${param.quantity}" /> --%>
	
</sql:query>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
	
	<h1>Hello SQL <small>JSTL</small></h1>
	<table class="table table-bordered table-striped table-hover">
	
		<tr>
			<c:forEach items="${items.columnNames}" var="colName">
				<th>${colName}</th>
			</c:forEach>
		</tr>
	
	  <c:forEach items="${items.rowsByIndex}" var="row">
	    <tr>
		    <c:forEach items="${row}" var="col">
		      
		        <td>${col}</td>
		      
		    </c:forEach>
	    </tr>
	  </c:forEach>
	</table>
    
</div>
</body>
</html>