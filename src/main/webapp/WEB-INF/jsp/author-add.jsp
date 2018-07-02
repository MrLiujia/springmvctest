<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加作者</title>
</head>
<body>
  <h1>添加作者</h1>
  <form action="" method="post">
    <div>
      <label for="name">姓名</label>
      <input type="text" name="name" id="name">
    </div>
    <div>
      <label>性别</label>
      <!-- 注意：单选按钮组的name应该一样，并且value要指定为枚举名 -->
      <input type="radio" name="gender" value="Male">男
      <input type="radio" name="gender" value="Female">女
    </div>
    <div>
      <label for="description">简介</label>
      <textarea name="description" id="description"></textarea>
    </div>
    <div>
      <button type="submit">添加</button>
    </div>
  </form>
</body>
</html>