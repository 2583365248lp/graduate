<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
 <form id="form1" name="form1" method="post" action="http://localhost:8080/user_reg/backend/Loginservlet">
 <%=(request.getAttribute("error")==null)?"":request.getAttribute("reeor") %>
<table width="978" border="0" cellspacing="2" cellpadding="2">
  <tr>
    <td height="60" colspan="2"><div align="center"><span class="STYLE1">用户登录</span></div></td>
  </tr>
  <tr>
    <td width="343" height="57"><span class="STYLE4">用户名</span></td>
    <td width="621"><input name="username" type="text" maxlength="20" />
      最多不超过20字符</td>
  </tr>
  <tr>
    <td height="55"><span class="STYLE4">密码</span></td>
    <td><input  type="password" name="password"  maxlength="20" />
      最多不超过20字符 
      <input type="submit" name="Submit" value="登录" /></td>
  </tr>
</table>

</form>
  </body>
</html>
