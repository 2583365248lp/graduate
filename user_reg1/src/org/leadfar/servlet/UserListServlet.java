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
//			users.add(new User(i,"zs"+i,new Random().nextBoolean()?"��":"Ů",new Date()));
//		}
		UserDao userDao=new UserDao();
		request.setAttribute("users", userDao.query());
		// "/"����Ӧ�ó������� /user_reg/list.jsp
		request.getRequestDispatcher("/list.jsp").forward(request, response);

	}

}
