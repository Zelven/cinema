package com.mzw.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.mzw.entity.Cinema;

import com.mzw.service.CinemaService;
import com.mzw.service.impl.CinemaServiceImpl;
import com.mzw.utils.JsonUtils;


/**
 * Servlet implementation class CinemaAddServlet
 */
@WebServlet("/movie/add.do")
public class CinemaAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CinemaService cinemaService = new CinemaServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CinemaAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String string = request.getParameter("Type");
		Cinema cinema = null;
		if (string == null || string == "") {
			cinema = new Cinema(request.getParameter("movieName"),null,request.getParameter("actor"),request.getParameter("director"),Double.parseDouble("price"));
		}else {
			cinema = new Cinema(request.getParameter("movieName"),request.getParameter("movieType"),request.getParameter("actor"),request.getParameter("director"),Double.parseDouble("price"));
		}
		try {
			cinemaService.add(cinema);
			JsonUtils.sendJsonData(1, null, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JsonUtils.sendJsonData(0, e.getMessage(), response);
		}
		
		
//		
//		String movieName = request.getParameter("movieName");
//		String movieType = request.getParameter("movieType");
//		String actor = request.getParameter("actor");
//		String director = request.getParameter("director");
//		String price = request.getParameter("price");
//		try {
//			Cinema c = new Cinema();
//			c.setMovieName(movieName);
//			c.setMovieType(movieType);
//			c.setActor(actor);
//			c.setDirector(director);
//			c.setPrice(Integer.parseInt(price));
//			cinemaService.add(c);
//			JsonUtils.sendJsonData(1, null, response);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			JsonUtils.sendJsonData(0, e.getMessage(), response);
//		}
		
//		
//		Cinema c = new Cinema();
//		try {
//			cinemaService.add(c);
//			JsonUtils.sendJsonData(1, null, response);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			JsonUtils.sendJsonData(0, e.getMessage(), response);
//		}
//		Cinema c = new Cinema();
//		
//		Map<String, String[]> parameterMap = request.getParameterMap();
//		//拷贝？ 将parameterMap拷贝到user里
//		//实现对象属性赋值。将map结构中对应的可以值的数据，赋值给对象同名的属性
//		
//		String movieName = parameterMap.get("movieName")[0];
//		String movieType = parameterMap.get("movieType")[0];
//		String actor = parameterMap.get("actor")[0];
//		String director = parameterMap.get("director")[0];
//		String price = parameterMap.get("price")[0];
//		
//		try {
//			BeanUtils.populate(c,parameterMap);
//			
//			
//			cinemaService.add(c);
//		
//			JsonUtils.sendJsonData(1, null, response);
//		
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			JsonUtils.sendJsonData(0, e.getMessage(), response);
//		}
		
//		
//		Cinema c = new Cinema();
//	
//		// 用Map获取并保存页面发送的新添加影片的各项信息
//		// String为key值，数组String[]为value值，为表单中多选项提供保障；
//		Map<String, String[]> map = request.getParameterMap();
//		
//		try {
//			
//			// 实现对象属性的赋值，可将map中对应的key值数据赋值给对象中同名的属性，注意要求属性的key值名称要一致
//			BeanUtils.populate(c, map);
//			
//			cinemaService.add(c);
//			
//			JsonUtils.sendJsonData(1, null, response);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			JsonUtils.sendJsonData(0, e.getMessage(), response);
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
