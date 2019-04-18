package com.mzw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mysql.jdbc.PreparedStatement;
import com.mzw.service.CinemaService;
import com.mzw.service.impl.CinemaServiceImpl;
import com.mzw.utils.JsonUtils;
import com.mzw.vo.VCinemaInfo;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/query.do")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CinemaService cinemaService = new CinemaServiceImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		Map<String, String[]> map = request.getParameterMap();
		try {
			List<VCinemaInfo> list = cinemaService.findByCondition(map);
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
