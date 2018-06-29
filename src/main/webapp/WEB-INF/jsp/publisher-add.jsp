<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加出版社</title>
</head>
<body>
  <h1>添加出版社</h1>
  <form action="" method="post">
    <div>
      <label for="name">名字</label>
      <input type="text" name="name" id="name">
    </div>
    <div>
      <label for="description">描述</label>
      <textarea rows="3" cols="80" name="description" id="description"></textarea>
    </div>
    <div>
      <button type="submit">添加</button>
    </div>
  </form>
</body>
</html>