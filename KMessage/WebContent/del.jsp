<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.henu.factory.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除消息</title>
</head>
<body>
<div>
<form action="MyServlet?action=mydel" method="post">
删除消息：
<input type="text" name="del" placeholder="请输入要删除消息的用户名称">
<input type="submit" value="删除">
</form>
</div>

</body>
</html>