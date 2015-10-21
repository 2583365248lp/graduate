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

public class UserUpdateInputServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id=Integer.parseInt(request.getParameter("id"));
		
		UserDao userDao=new UserDao();
		
		User user=userDao.get(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/update_input.jsp").forward(request, response);

	}

}
