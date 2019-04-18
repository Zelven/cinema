package com.mzw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mzw.service.TypeService;
import com.mzw.service.impl.TypeServiceImpl;
import com.mzw.utils.JsonUtils;
import com.mzw.vo.VTypeInfo;

/**
 * Servlet implementation class TypeListServlet
 */
@WebServlet("/type/list.do")
public class TypeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TypeService typeService = new TypeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String typeLevel = request.getParameter("tlevel");
		//查所有
		if (typeLevel == null) {
			try {
				List<VTypeInfo> list = typeService.findAllType();
				JsonUtils.sendJsonData(1, list, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JsonUtils.sendJsonData(0, null, response);
			}
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
