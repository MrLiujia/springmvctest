<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>      

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加管理员</title>
  <link href="${contextPath}/assets/css/form.css" rel="stylesheet">
</head>
<body>
  <h1>添加管理员</h1>
<!--    action为空意味着会提交到当前表单页面的路径 -->
  <form:form action="" method="post" commandName="operator">
    <div>
      <label for="username">用户名</label>
      <form:input type="text" path="username" id="username" />
      <form:errors path="username" cssClass="field-error" />
    </div>
    <div>
      <label for="password">密码</label>
      <form:input type="password" path="password" id="password" />
      <form:errors path="password" cssClass="field-error" />
    </div>
    <div>
      <label for="roleId">角色</label>
      <form:select path="role.id" id="roleId"
                   items="${roleOptions}" 
                   itemLabel="name"
                   itemValue="id" />
      <form:errors path="role.id" cssClass="field-error" />
    </div>    
    <div> 
      <button type="submit">添加</button>
    </div>
  </form:form>
</body>
</html>