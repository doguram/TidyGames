package com.TidyGames.report.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.report.model.service.ReportService;

/**
 * Servlet implementation class AdminUnblockBlacklistController
 */
@WebServlet("/unblock.re")
public class AdminUnblockBlacklistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUnblockBlacklistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String userId = request.getParameter("user"); 
			System.out.println(userId);
				
			int result = new ReportService().unblock(userId);
			
			request.getSession().setAttribute("alertMsg", "차단이 해제되었습니다.");
			response.sendRedirect(request.getContextPath() + "/blacklist.re?cpage=1");
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
