<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书列表</title>
</head>
<body>
	<h1>图书列表</h1>
	<ul>
	   <c:forEach items="${books}" var="book">
	     <li>#${book.id} 
         <a href="${contextPath}/books/book-details/${book.id}">${book.title}</a></li>
	   </c:forEach>
	</ul>
</body>
</html>