<%@ tag language="java" pageEncoding="UTF-8"%>

<!-- 调用该tag时还需传参title以指定页面标题 -->
<%@ attribute name="title" required="true" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>${title}</title>
  
  <link href="${contextPath}/assets/css/form.css" rel="stylesheet">  
  <style>
   .menu {
    display: inline-block;
   }
  </style>
</head>
<body>
  <div class="header">
    <sec:authorize access="hasAnyAuthority('PERM_BOOK_RO', 'PERM_BOOK_RW')">
      <ul class="menu">
        <li>图书管理</li>
        <sec:authorize access="hasAnyAuthority('PERM_BOOK_RO', 'PERM_BOOK_RW')">
          <li><a href="${contextPath}/books/">图书列表</a></li>
        </sec:authorize>
        
        <sec:authorize access="hasAuthority('PERM_BOOK_RW')">
          <li><a href="${contextPath}/books/add">添加图书</a></li>
        </sec:authorize>
      </ul>
    </sec:authorize>
    
    <sec:authorize access="hasAnyAuthority('PERM_AUTHOR_RO', 'PERM_AUTHOR_RW')">
      <ul class="menu">
        <li>作者管理</li>
        <sec:authorize access="hasAnyAuthority('PERM_AUTHOR_RO', 'PERM_AUTHOR_RW')">
          <li><a href="${contextPath}/authors/">作者列表</a></li>
        </sec:authorize>
        <sec:authorize access="hasAuthority('PERM_AUTHOR_RW')">
          <li><a href="${contextPath}/authors/add">添加作者</a></li>
        </sec:authorize>
      </ul>  
    </sec:authorize>
   
   <sec:authorize access="hasAnyAuthority('PERM_PUBLISHER_RO', 'PERM_PUBLISHER_RW')">
      <ul class="menu">
        <li>出版社管理</li>
        <sec:authorize access="hasAnyAuthority('PERM_PUBLISHER_RO', 'PERM_PUBLISHER_RW')">
          <li><a href="${contextPath}/publishers/">出版社列表</a></li>
        </sec:authorize>
        
        <sec:authorize access="hasAuthority('PERM_PUBLISHER_RW')">
          <li><a href="${contextPath}/publishers/add">添加出版社</a></li>
        </sec:authorize>
      </ul>    
   </sec:authorize>
    
    <div style="display: inline-block;">
<!--                                principal属性可以拿到当前登录的用户详情（UserDetailsImpl） -->
      <sec:authentication property="principal.username" />
      
      <!-- 先把当前登录用户的email存入页面域变量operatorEmail -->
      <sec:authentication property="principal.operator.email" var="operatorEmail" />
      
      <c:if test="${operatorEmail != null}">
        [${operatorEmail}]
      </c:if>
      
      <!-- springsecurity默认的退出路径是：POST /logout，注意：springsecurity自带处理 -->
      <form action="${contextPath}/logout" method="post" style="display: inline;">
        <sec:csrfInput />
        <button type="submit">退出</button>
      </form>
    </div> 
  </div>
  
  <div class="content">
    <!-- 取tag参数值 -->
    <h1>${title}</h1>
    <!-- 把t:layout标签的内容插入此处 -->
    <jsp:doBody />
  </div>
  
  <div class="footer">copyright 2018</div>
</body>
</html>