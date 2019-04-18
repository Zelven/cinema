package com.mzw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mzw.service.CinemaService;
import com.mzw.service.impl.CinemaServiceImpl;
import com.mzw.utils.JsonUtils;

/**
 * Servlet implementation class CinemaDeleteServlet
 */
@WebServlet("/movie/delete.do")
public class CinemaDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CinemaService cinemaService = new CinemaServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CinemaDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		cinemaService.deleteCinemaById(Integer.parseInt(id));
		JsonUtils.sendJsonData(1, null, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
