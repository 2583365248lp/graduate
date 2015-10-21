package org.leaderfar.cms.backend.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.leaderfar.cms.backend.dao.Userdao;

public class Loginservlet extends HttpServlet {

	private Userdao userDao = new Userdao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	    doPost(request , response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//取参数
		String username =request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		
		boolean flag= userDao.login(username, password);
		if(flag){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			request.setAttribute("error", "用户名或密码输入错误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
