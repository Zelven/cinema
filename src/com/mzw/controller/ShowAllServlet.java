package com.mzw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mzw.entity.Cinema;
import com.mzw.service.UserService;
import com.mzw.service.impl.UserServiceImpl;
import com.mzw.utils.JsonUtils;


/**
 * Servlet implementation class ShowAllServlet
 */
@WebServlet("/showAll.do")
public class ShowAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Cinema> list = userService.findAll();
			JsonUtils.sendJsonData(1, list, response);
		} catch (Exception e) {
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
