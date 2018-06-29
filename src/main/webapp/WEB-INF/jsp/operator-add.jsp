<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加管理员</title>
</head>
<body>
  <h1>添加管理员</h1>
<!--    action为空意味着会提交到当前表单页面的路径 -->
  <form action="" method="post">
    <div>
      <label for="username">用户名</label>
      <input type="text" name="username" id="username">
    </div>
    <div>
      <label for="password">密码</label>
      <input type="password" name="password" id="password">
    </div>
    <div> 
      <button type="submit">添加</button>
    </div>
  </form>
</body>
</html>