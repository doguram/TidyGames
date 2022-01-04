package com.TidyGames.report.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.report.model.service.ReportService;
import com.TidyGames.report.model.vo.Report;

/**
 * Servlet implementation class AdminAccessBlock
 */
@WebServlet("/block.re")
public class AdminAccessBlock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAccessBlock() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String user = request.getParameter("user");
			int reportNo = Integer.parseInt(request.getParameter("rno"));	
			
			int result = new ReportService().accessBlock(user, reportNo);
			
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", user + "를 차단했습니다.");
				response.sendRedirect(request.getContextPath() + "/reportWait.re?cpage=1");
				
			}else {
				request.getSession().setAttribute("alertMsg", "오류가 발생했습니다. 다시 확인해주세요.");
				response.sendRedirect(request.getContextPath());
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
