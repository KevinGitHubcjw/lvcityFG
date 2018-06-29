<%@page import="com.henu.factory.MessageDaoFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List" import="java.util.ArrayList" import="com.henu.bean.Message"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示消息</title>
</head>
<body>
 <% List<Message> ArticleList=MessageDaoFactory.getMessageInstance().findAll(); 
 Message megs=new Message();
 for(int i=0;i<ArticleList.size();i++)
 {  
	  megs =(Message)(ArticleList.get(i));
	  %>
	  内容：<%=megs.getMessage() %><br>
	  作者：<%=megs.getUsername() %><br>
	  时间：<%=megs.getSubmitTime() %><br>
	  <br>
	  <br>
	  <%
 }
 %>
</body>
</html>