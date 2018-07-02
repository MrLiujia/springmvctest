<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加作者</title>

  <style type="text/css">
   .field-error {
     color: red;
   }
  </style>
</head>
<body>
  <h1>添加作者</h1>
<!--                                 commandName指定表单bean的model名 -->
  <form:form action="" method="post" commandName="author">
    <div>
      <label for="name">姓名</label>
<!--                          path指定该字段对应的pojo属性名 -->
      <form:input type="text" path="name" id="name" />
<!--                           cssClass给错误消息标签加class="field-error"以便应用校验错误样式 -->
      <form:errors path="name" cssClass="field-error"></form:errors>
    </div>
    <div>
      <label>性别</label>
      <!-- 注意：单选按钮组的name应该一样，并且value要指定为枚举名 -->
      <form:radiobutton path="gender" value="Male" />男
      <form:radiobutton path="gender" value="Female" />女
      <form:errors path="gender" cssClass="field-error"></form:errors>
    </div>
    <div>
      <label for="description">简介</label>
      <form:textarea path="description" id="description"/>
      <form:errors path="description" cssClass="field-error"></form:errors>
    </div>
    <div>
      <button type="submit">添加</button>
    </div>
  </form:form>
</body>
</html>