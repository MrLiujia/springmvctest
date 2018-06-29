<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作者详情</title>
</head>
<body>
  <h1>作者详情</h1>
  <div>
    <h2>${author.name}</h2>
    <div>
      [${author.gender}]
      <p>${author.description}</p>
      <div>
        <h3>所著图书</h3>
        <ul>
          <c:forEach items="${author.books}" var="book">
            <li>${book.title}【${book.publisher.name}】</li>
          </c:forEach>        
        </ul>
      </div>
    </div>
  </div>
</body>
</html>