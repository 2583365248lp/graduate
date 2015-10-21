package org.leadfar.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.leadfar.dao.UserDao;
import org.leadfar.model.User;

public class UserUpdateServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//逐一接收参数
		User user=new User();
		user.setId(Integer.parseInt(request.getParameter("id")));
		user.setName(request.getParameter("name"));
		user.setSex(request.getParameter("sex"));
		Date d=null;
		try {
			d = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
			user.setBirthday(d);
		} catch (ParseException e) {
			user.setBirthday(new Date());
			e.printStackTrace();
		}
		
		
		//未来需要存到数据库中
		
		UserDao userDao=new UserDao();
		userDao.update(user);
		
		//转向成功页面
		// 客户端的"/" 不包含应用程序名称 http://localhost:8080 /user_reg
		response.sendRedirect(request.getContextPath()+"/servlet/UserListServlet");

	}

}
