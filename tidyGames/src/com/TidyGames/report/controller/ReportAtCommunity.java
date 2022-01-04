package com.TidyGames.report.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TidyGames.member.model.vo.Member;
import com.TidyGames.post.model.vo.Reply;
import com.TidyGames.report.model.service.ReportService;
import com.TidyGames.report.model.vo.Report;

/**
 * Servlet implementation class ReportAtCommunity
 */
@WebServlet("/report.re")
public class ReportAtCommunity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportAtCommunity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int postNo = Integer.parseInt(request.getParameter("pno"));
			String memNo = request.getParameter("mno");
			String sort = request.getParameter("sno");
			String etc = request.getParameter("etc");
			
			int reporting = ((Member)request.getSession().getAttribute("loginUser")).getMemNo();
			
			Report r = new Report();
			r.setPostNo(postNo);
			r.setReported(memNo);
			r.setReportSort(sort);
			r.setEtc(etc);
			r.setReporting(String.valueOf(reporting));
			

			int result = new ReportService().reportAtCommunity(r);
			
			response.getWriter().print(result);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
