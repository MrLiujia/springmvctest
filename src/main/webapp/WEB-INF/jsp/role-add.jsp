<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>      
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加角色</title>

  <style type="text/css">
   .field-error {
     color: red;
   }
  </style>
</head>
<body>
  <h1>添加角色</h1>
<!--    action为空意味着会提交到当前表单页面的路径 -->
  <form:form action="" method="post" commandName="roleForm">
    <div>
      <label for="name">名称</label>
      <form:input type="text" path="name" id="name" />
      <form:errors path="name" cssClass="field-error" />
    </div>
    <div>
      <label for="description">描述</label>
      <form:textarea path="description" id="description" />
      <form:errors path="description" cssClass="field-error" />
    </div>
    <div>
      <label for="permissionIds">权限</label>
      <form:select path="permissionIds" id="permissionIds"
                   items="${permissionOptions}" 
                   itemLabel="name"
                   itemValue="id" />
      <form:errors path="permissionIds" cssClass="field-error" />
    </div>    
    <div> 
      <button type="submit">添加</button>
    </div>
  </form:form>
</body>
</html>