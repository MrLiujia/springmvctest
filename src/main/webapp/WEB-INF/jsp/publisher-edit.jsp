<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="title" value="${publisher.id == null ? '添加出版社' : '修改出版社'}"></c:set>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
  <link href="${contextPath}/assets/css/form.css" rel="stylesheet"> 
</head>
<body>
  <h1>${title}</h1>
  <form:form action="" method="post" commandName="publisher">
    <div>
      <label for="name">名字</label>
      <form:input type="text" path="name" id="name" />
      <form:errors path="name" cssClass="field-error" />
    </div>
    <div>
      <label for="description">描述</label>
      <form:textarea rows="3" cols="80" path="description" id="description" />
      <form:errors path="description" cssClass="field-error" />
    </div>
    <div>
      <button type="submit">添加</button>
    </div>
  </form:form>
</body>
</html>