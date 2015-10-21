package org.leadfar.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.leadfar.dao.UserDao;

public class UserListServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		List<User> users=new ArrayList<User>();
//		for(int i=0;i<5;i++){
//			users.add(new User(i,"zs"+i,new Random().nextBoolean()?"男":"女",new Date()));
//		}
		UserDao userDao=new UserDao();
		request.setAttribute("users", userDao.query());
		// "/"包含应用程序名称 /user_reg/list.jsp
		request.getRequestDispatcher("/list.jsp").forward(request, response);

	}

}
