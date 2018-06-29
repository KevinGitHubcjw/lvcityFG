<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加消息</title>
</head>
<body>
<h2>添加消息</h2>
<form action="MyServlet?action=add" method="post">
<p>消息内容：<textarea rows="10" cols="50" id="content" name="content"></textarea></p>
<p>用户名：<input type="text" id="name" name="name"/></p>
<p><input type="submit" value="添加"></p>
</form>
</body>
</html>