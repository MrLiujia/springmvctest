<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加出版社</title>
  <style type="text/css">
   .field-error {
     color: red;
   }
  </style>  
</head>
<body>
  <h1>添加出版社</h1>
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