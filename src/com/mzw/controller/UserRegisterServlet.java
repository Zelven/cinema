package com.mzw.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.mzw.entity.User;
import com.mzw.service.UserService;
import com.mzw.service.impl.UserServiceImpl;
import com.mzw.utils.JsonUtils;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/user/register.do")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		//获取所有数据
		Map<String, String[]> parameterMap = request.getParameterMap();
		//拷贝？ 将parameterMap拷贝到user里
		//实现对象属性赋值。将map结构中对应的可以值的数据，赋值给对象同名的属性
		
		String name = parameterMap.get("name")[0];
		String password = parameterMap.get("password")[0];
		String repassword = parameterMap.get("repassword")[0];
		if (!password.equals(repassword)) {
			JsonUtils.sendJsonData(0, "两次密码不一致", response);
			return;
		}
		if (name == null) {
			JsonUtils.sendJsonData(0, "请输入用户名", response);
		}
		try {
			BeanUtils.populate(user,parameterMap);
			
			
			userService.register(user);
		
			JsonUtils.sendJsonData(1, null, response);
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JsonUtils.sendJsonData(0, e.getMessage(), response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
