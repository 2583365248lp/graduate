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
	<script type="text/javascript">
		
			function del(id){
				if(confirm("确认要删除吗?")){
					var url="<%=basePath%>servlet/UserDeleteServlet?id="+id;
					window.location.href=url;
				}
			}
	</script>
  </head>
  
  <body>
  <% List<User> users=(List<User>)request.getAttribute("users"); %>
   
   <table border="1" width="60%">
   	<tr>
   		<td>ID</td>
   		<td>姓名</td>
   		<td>性别</td>
   		<td>生日</td>
   		<td>注册时间</td>
   		<td>操作</td>
   	</tr>
   	<% for(User u:users){ %>
   		<tr>
   		<td><%=u.getId() %></td>
   		<td><%=u.getName() %></td>
   		<td><%=u.getSex() %></td>
   		<td><%=u.getBirthday() %></td>
   		<td><%=u.getRegTime() %></td>
   		<td><a href="servlet/UserUpdateInputServlet?id=<%=u.getId() %>">编辑</a>  | <a href="javascript:del(<%=u.getId() %>)">删除</a></td>
   	</tr>
   	<%} %>
   </table>
  </body>
</html>
