<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%-- set data source --%>
<sql:setDataSource
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://cs3.calstatela.edu/cs3220stu120"
	user="cs3220stu120"
	password="" />

<%-- query --%>
<sql:query var="items" sql="SELECT * FROM items"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table>
  <c:forEach items="${items.rows}" var="row">
    <c:forEach items="${row}" var="col">
      <tr>
        <td>${col.key}</td>
        <td>${col.value}</td>
      </tr>
    </c:forEach>
    <tr>
    <td colspan="2"><hr></td>
    </tr>
  </c:forEach>
</table>
    

</body>
</html>