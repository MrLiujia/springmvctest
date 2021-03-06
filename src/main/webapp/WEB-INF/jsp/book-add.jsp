<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<c:set var="contextPath" value="${pageContext.request.contextPath}" />   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书</title>
  <link href="${contextPath}/assets/css/form.css" rel="stylesheet">
</head>
<body>
  <h1>添加图书</h1>
  <form:form action="" method="post" commandName="bookForm">
    <div>
      <label for="title">书名</label>
      <form:input type="text" path="title" id="title" />
      <form:errors path="title" cssClass="field-error" />
    </div>
    <div>
      <label for="description">简介</label>
      <form:textarea path="description" id="description" />
      <form:errors path="description" cssClass="field-error" />
    </div>   
    
    <div>
      <label for="authorIds">作者</label>
<!--       items指定用于生成选项的pojo列表 -->
<!--       itemLabel指定作为option的显示文本的pojo属性 -->
<!--       itemValue指定作为option的提交值的pojo属性 -->
      <form:select path="authorIds" id="authorIds"> 
        <form:option value="" label="--请选择作者--" />  
        <form:options items="${authorOptions}" 
                      itemLabel="name" 
                      itemValue="id" /> 
      </form:select>
      <form:errors path="authorIds" cssClass="field-error" />
    </div> 
    <div>
      <label for="publisherId">出版社</label>
      <form:select path="publisherId" id="publisherId">
        <form:option value="" label="--请选择出版社--" />
        <form:options items="${publisherOptions}" 
                      itemLabel="name" 
                      itemValue="id" />                                 
      </form:select>
      <form:errors path="publisherId" cssClass="field-error" />
    </div>   
    <div>
      <button type="submit">保存</button>
    </div>      
  </form:form>
</body>
</html>