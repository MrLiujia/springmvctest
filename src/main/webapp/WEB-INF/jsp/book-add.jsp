<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加图书</title>
  <style type="text/css">
   .field-error {
     color: red;
   }
  </style>
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
    
<!--     <div> -->
<!--       <label for="authorId">作者</label> -->
<!-- <!--       items指定用于生成选项的pojo列表 --> -->
<!-- <!--       itemLabel指定作为option的显示文本的pojo属性 --> -->
<!-- <!--       itemValue指定作为option的提交值的pojo属性 --> -->
<%--       <form:select path="authors[0].id" id="authorId"  --%>
<%--                    items="${authorOptions}"  --%>
<%--                    itemLabel="name"  --%>
<%--                    itemValue="id"> --%>
<%--       </form:select> --%>
      
<%--       <form:select path="authors[1].id" --%>
<%--                    items="${authorOptions}"  --%>
<%--                    itemLabel="name"  --%>
<%--                    itemValue="id"> --%>
<%--       </form:select> --%>

<%--       <form:select path="authors[2].id"  --%>
<%--                    items="${authorOptions}"  --%>
<%--                    itemLabel="name"  --%>
<%--                    itemValue="id"> --%>
<%--       </form:select> --%>
<!--     </div>  -->

    <div>
      <label for="publisherId">出版社</label>
      <form:select path="publisherId" id="publisherId"
                   items="${publisherOptions}"
                   itemLabel="name"
                   itemValue="id">
      </form:select>
      <form:errors path="publisherId" cssClass="field-error" />
    </div>   
    <div>
      <button type="submit">保存</button>
    </div>      
  </form:form>
</body>
</html>