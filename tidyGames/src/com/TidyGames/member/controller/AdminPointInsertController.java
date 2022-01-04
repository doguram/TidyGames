package com.TidyGames.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.member.model.service.PointService;

/**
 * Servlet implementation class AdminPointInsertController
 */
@WebServlet("/adPointInsert.me")
public class AdminPointInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPointInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int memNo = Integer.parseInt(request.getParameter("mNo"));
		
		String memNo = request.getParameter("memNo");
		int pa = Integer.parseInt(request.getParameter("pointAmount"));
		String pc = request.getParameter("pointContent");
		
		System.out.println(memNo);
		System.out.println(pa);
		System.out.println(pc);
		
		int result = new PointService().adInsertPoint(memNo, pa, pc );
		
		if(result > 0) {
			
			response.getWriter().print(result);
			
			
			request.getSession().setAttribute("alertMsg", "포인트적립에 성공하였습니다");
			response.sendRedirect(request.getContextPath() + "/adPoint.me");
			
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
