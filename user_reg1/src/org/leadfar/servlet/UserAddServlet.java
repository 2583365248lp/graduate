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

public class UserAddServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//��һ���ղ���
		User user=new User();
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
		
		
		//δ����Ҫ�浽���ݿ���
		
		UserDao userDao=new UserDao();
		userDao.save(user);
		
		//ת��ɹ�ҳ��
		// �ͻ��˵�"/" ������Ӧ�ó������� http://localhost:8080 /user_reg
		response.sendRedirect(request.getContextPath()+"/add_success.jsp");

	}

}
