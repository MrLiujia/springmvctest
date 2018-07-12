<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!-- 调用布局，内容将插入布局的content区域 -->
<t:layout title="作者详情">
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
</t:layout>
