package com.hanabi.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import com.hanabi.domain.User;
import com.hanabi.service.UserService;

/**
 * 登录
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//2.接受用户名和密码
		Map map = request.getParameterMap();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		//3.调用userservice getUserByUsernameAndPwd()  返回值 user
		User user=null;
		try {
			user = new UserService().getUserByUsernameAndPwd(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.setContentType("application/json;charset=utf-8");//指定返回的格式为JSON格式
		response.setCharacterEncoding("UTF-8");//setContentType与setCharacterEncoding的顺序不能调换，否则还是无法解决中文乱码的问题
		response.setHeader("Access-Control-Allow-Origin", "*");
		String jsonStr = null;

		//4.判断user
		if(user==null){
			//4.1若user为空 提示信息,请求转发到login.jsp
			jsonStr = "{\"msg\":\"登录出错\",\"ret\":\"-1\"}";
		}else{
			jsonStr = "{\"msg\":\"欢迎光临\",\"ret\":\"0\"}";
		}

		PrintWriter out =null ;
		out =response.getWriter() ;
		out.write(jsonStr);
		out.close();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
