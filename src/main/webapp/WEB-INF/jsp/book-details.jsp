<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书详情</title>
</head>
<body>
  <h1>图书详情</h1>
  <div>
    <h2>${book.title}</h2>
    <div>出版社：${book.publisher.name}</div>
    <div>作者：
      <ul>
        <c:forEach items="${book.authors}" var="author">
          <li>${author.name} [${author.gender}]</li>
        </c:forEach>      
      </ul>
    </div>
  </div>
</body>
</html>