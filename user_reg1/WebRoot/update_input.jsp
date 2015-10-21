<%@ page language="java" import="java.util.*,org.leadfar.model.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
 <h4>学籍添加</h4>
  	<hr/>
  	<% User user=(User)request.getAttribute("user"); %>
     <form action="servlet/UserUpdateServlet" method="post">
     <input type="hidden" name="id" value="<%=user.getId() %>"/><br/>
     	用户名:<input type="text" name="name" value="<%=user.getName() %>"/><br/>
     	性别:<input type="radio" name="sex" value="男" <%=user.getSex().equals("男")?"checked":"" %>/>男<input type="radio" name="sex" <%=user.getSex().equals("女")?"checked":"" %> value="女"/>女<br/>
     	生日:<input type="text" name="birthday" value="<%=user.getBirthday() %>" /><br/>
     	<br/>
     	<input type="submit" value="提交"/>
     	
     </form>
  </body>
</html>
