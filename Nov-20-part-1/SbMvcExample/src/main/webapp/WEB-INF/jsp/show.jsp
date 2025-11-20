<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ol type="1">
	<c:forEach var="x" items="${names}">
		<c:out value="${x}" /> <br/>
	</c:forEach>
	</ol>
</body>
</html>