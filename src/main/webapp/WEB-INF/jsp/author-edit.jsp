<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %> 

<c:set var="pageTitle" value="${author.id == null ? '添加作者' : '修改作者'}"></c:set>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!--      给tag传参 -->
<t:layout title="${pageTitle}">
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
      <button type="submit">保存</button>
    </div>
  </form:form>
</t:layout>
